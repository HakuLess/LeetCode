package leetcode.contest.last.e00;

import java.util.HashMap;

public class V4 {
    public static void main(String[] args) {
        V4 v4 = new V4();
        int res = v4.domino(2, 3, new int[][]{{1, 0}, {1, 1}});
        System.out.println(res);

        long h = 2L << 61;
        System.out.println(h);
    }

    private HashMap<Long, Integer> map = new HashMap<>();

    public int domino(int n, int m, int[][] broken) {

        long hash = getBrokenHash(broken);
        if (map.containsKey(hash)) {
            return map.get(hash);
        }

        System.out.println(hash);
        for (int[] ints : broken) {
            System.out.println(ints[0] + " " + ints[1]);
        }
        System.out.println();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isBroken(i, j, broken)) {
                    if (j + 1 < m && !isBroken(i, j + 1, broken)) {
                        int[][] cp = new int[broken.length + 2][2];
                        for (int k = 0; k < broken.length; k++) {
                            cp[k][0] = broken[k][0];
                            cp[k][1] = broken[k][1];
                        }
                        cp[cp.length - 2][0] = i;
                        cp[cp.length - 2][1] = j;
                        cp[cp.length - 1][0] = i;
                        cp[cp.length - 1][1] = j + 1;
                        ans = Math.max(ans, 1 + domino(n, m, cp));
                    }
                    if (i + 1 < n && !isBroken(i + 1, j, broken)) {
                        int[][] cp = new int[broken.length + 2][2];
                        for (int k = 0; k < broken.length; k++) {
                            cp[k][0] = broken[k][0];
                            cp[k][1] = broken[k][1];
                        }
                        cp[cp.length - 2][0] = i;
                        cp[cp.length - 2][1] = j;
                        cp[cp.length - 1][0] = i + 1;
                        cp[cp.length - 1][1] = j;
                        ans = Math.max(ans, 1 + domino(n, m, cp));
                    }

                    int[][] cp = new int[broken.length + 1][2];
                    for (int k = 0; k < broken.length; k++) {
                        cp[k][0] = broken[k][0];
                        cp[k][1] = broken[k][1];
                    }
                    cp[cp.length - 1][0] = i;
                    cp[cp.length - 1][1] = j;
                    ans = Math.max(ans, domino(n, m, cp));
                }
            }
        }
        map.putIfAbsent(hash, ans);
        return ans;
    }

    private long getBrokenHash(int[][] broken) {
        long ans = 0L;
        for (int[] ints : broken) {
            ans += 2L << ints[0] + ints[1] * 8;
        }
        return ans;
    }

    private boolean isBroken(int i, int j, int[][] broken) {
        for (int[] ints : broken) {
            if (ints[0] == i && ints[1] == j) {
                return true;
            }
        }
        return false;
    }
}
