package leetcode.contest.last.e00;

import java.util.ArrayList;
import java.util.List;

public class V5 {
    public static void main(String[] args) {
        V5 v5 = new V5();
        int[] ans = v5.bonus(6, new int[][]{{1, 2}, {1, 6}, {2, 3}, {2, 5}, {1, 4}}, new int[][]{{1, 1, 500}, {2, 2, 50}, {3, 1}, {2, 6, 15}, {3, 1}});
        for (int an : ans) {
            System.out.print(an + ", ");
        }
    }

    private static int mod = 1000000007;

    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        List<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            a.add(new ArrayList<>());
        }
        for (int[] ints : leadership) {
            a.get(ints[0]).add(ints[1]);
        }

        dfs(a, 1);

//        for (int i = 0; i < a.size(); i++) {
//            for (Integer integer : a.get(i)) {
//                System.out.print(integer + ", ");
//            }
//            System.out.println();
//        }

        int[] cur = new int[n + 1];

        List<Integer> ans = new ArrayList<Integer>();
        for (int[] operation : operations) {
            if (operation[0] == 1) {
                cur[operation[1]] += operation[2];
            } else if (operation[0] == 2) {
                cur[operation[1]] += operation[2];
                for (Integer integer : a.get(operation[1])) {
                    cur[integer] += operation[2];
                }
            } else {
                int c = cur[operation[1]];
                for (Integer integer : a.get(operation[1])) {
                    c %= mod;
                    c += cur[integer];
                    c %= mod;
                }
                ans.add(c);
            }

//            for (int i : cur) {
//                System.out.print(i + ", ");
//            }
//            System.out.println();
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private void dfs(List<ArrayList<Integer>> a, int index) {
        ArrayList<Integer> cur = a.get(index);
        ArrayList<Integer> clone = new ArrayList(cur);
        for (Integer integer : cur) {
            dfs(a, integer);
            clone.addAll(a.get(integer));
        }
        a.set(index, clone);
    }
}
