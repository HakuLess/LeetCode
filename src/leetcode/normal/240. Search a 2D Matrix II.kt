package leetcode.normal

class Solution240 {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return false
        }
        var col = matrix[0].lastIndex
        var row = 0
        while (col >= 0 && row <= matrix.lastIndex) {
            when {
                target == matrix[row][col] -> return true
                target < matrix[row][col] -> col--
                target > matrix[row][col] -> row++
            }
        }
        return false
    }
}