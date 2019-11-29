package leetcode.normal

class Solution73 {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        if (matrix.isEmpty()) {
            return
        }
        val setX = hashSetOf<Int>()
        val setY = hashSetOf<Int>()
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == 0) {
                    setX.add(i)
                    setY.add(j)
                }
            }
        }

        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (i in setX || j in setY) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}