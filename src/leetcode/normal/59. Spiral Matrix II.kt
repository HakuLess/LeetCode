package leetcode.normal

class Solution59 {
    fun generateMatrix(n: Int): Array<IntArray> {
        val ans = Array(n) { IntArray(n) }
        var dir = "right"
        var x = 0
        var y = 0
        for (i in 0 until n * n) {
            if (ans[x][y] == 0) {
                ans[x][y] = i + 1
            }
            when (dir) {
                "right" -> {
                    if (y + 1 == n || ans[x][y + 1] != 0) {
                        dir = "down"
                        x++
                    } else {
                        y++
                    }
                }
                "down" -> {
                    if (x + 1 == n || ans[x + 1][y] != 0) {
                        dir = "left"
                        y--
                    } else {
                        x++
                    }
                }
                "left" -> {
                    if (y - 1 == -1 || ans[x][y - 1] != 0) {
                        dir = "top"
                        x--
                    } else {
                        y--
                    }
                }
                "top" -> {
                    if (x - 1 == -1 || ans[x - 1][y] != 0) {
                        dir = "right"
                        y++
                    } else {
                        x--
                    }
                }
            }
        }
        return ans
    }
}