package leetcode.contest.last.b14;


public class Solution5136 {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        int res = 0;
        if (sea.hasShips(topRight, bottomLeft)) {
            if (bottomLeft[0] < topRight[0]) {
                int m = (bottomLeft[0] + topRight[0]) / 2;
                res += countShips(sea, new int[]{m, topRight[1]}, bottomLeft);
                res += countShips(sea, topRight, new int[]{m + 1, bottomLeft[1]});
            } else if (bottomLeft[1] < topRight[1]) {
                int m = (bottomLeft[1] + topRight[1]) / 2;
                res += countShips(sea, new int[]{topRight[0], m}, bottomLeft);
                res += countShips(sea, topRight, new int[]{bottomLeft[0], m + 1});
            } else {
                res = 1;
            }
        }
        return res;
    }

    class Sea {
        public boolean hasShips(int[] topRight, int[] bottomLeft) {
            return true;
        }
    }
}
