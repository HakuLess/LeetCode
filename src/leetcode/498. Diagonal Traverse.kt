package leetcode

fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
    if (matrix.isEmpty()) {
        return intArrayOf()
    }
    val n = matrix.size
    val m = matrix[0].size
    val ans = arrayListOf<Int>()
    var top = false
    for (sum in 0 until n + m) {
        top = if (top) {
            for (i in 0..sum) {
                if (i < matrix.size && sum - i < matrix[0].size) {
                    ans.add(matrix[i][sum - i])
                }
            }
            false
        } else {
            for (i in 0..sum) {
                if (sum - i < matrix.size && i < matrix[0].size) {
                    ans.add(matrix[sum - i][i])
                }
            }
            true
        }
    }

    return ans.toIntArray()
}