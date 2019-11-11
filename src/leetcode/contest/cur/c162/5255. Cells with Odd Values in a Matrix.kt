package leetcode.contest.cur.c162

class Solution5255 {
    fun oddCells(n: Int, m: Int, indices: Array<IntArray>): Int {
        val matrix = Array<IntArray>(n) { IntArray(m) { 0 } }
        for (array in indices) {
            val x = array[0]
            val y = array[1]
            for (i in 0 until n) {
                for (j in 0 until m) {
                    if (i == x) {
                        matrix[i][j]++
                    }
                    if (j == y) {
                        matrix[i][j]++
                    }
                }
            }
        }
        var ans = 0
        matrix.forEach {
            it.forEach { item ->
                if (item % 2 == 1) {
                    ans++
                }
            }
        }
        return ans
    }
}