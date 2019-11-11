package leetcode.contest.last.e00;

public class V3 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int curX = 0;
        int curY = 0;
        int totalX = 0;
        int totalY = 0;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'U') {
                totalY++;
            } else {
                totalX++;
            }
        }

        int min = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'U') {
                curY++;
            } else {
                curX++;
            }
            for (int[] obstacle : obstacles) {
                if ((obstacle[0] - curX) % totalX == 0 &&
                        (obstacle[1] - curY) % totalY == 0 &&
                        (obstacle[0] - curX) / totalX == (obstacle[1] - curY) / totalY) {
                    min = Math.min(min, obstacle[0] + obstacle[1]);
                }
            }
            if ((x - curX) % totalX == 0 &&
                    (y - curY) % totalY == 0 &&
                    (x - curX) / totalX == (y - curY) / totalY) {
                ans = Math.min(ans, x + y);
            }
        }
        return ans < min;
    }
}
