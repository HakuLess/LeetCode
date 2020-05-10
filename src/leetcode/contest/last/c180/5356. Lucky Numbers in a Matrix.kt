package leetcode.contest.last.c180

class Solution5356 {
    fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
        val ans = ArrayList<Int>()
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (check(matrix, i, j)) {
                    ans.add(matrix[i][j])
                }
            }
        }
        return ans
    }

    private fun check(matrix: Array<IntArray>, x: Int, y: Int): Boolean {
        if (matrix[x][y] != matrix[x].min()!!) {
            return false
        }
        val cmp = arrayListOf<Int>()
        matrix.forEach {
            cmp.add(it[y])
        }
        if (matrix[x][y] != cmp.max()) {
            return false
        }
        return true
    }
}