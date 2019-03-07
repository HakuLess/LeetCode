package leetcode

class Solution73 {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return
        }
        val setX = hashSetOf<Int>()
        val setY = hashSetOf<Int>()
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[0].size) {
                if (matrix[i][j] == 0) {
                    setX.add(i)
                    setY.add(j)
                }
            }
        }

        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[0].size) {
                when {
                    i in setX -> matrix[i][j] = 0
                    j in setY -> matrix[i][j] = 0
                    else -> {

                    }
                }
            }
        }
    }
}