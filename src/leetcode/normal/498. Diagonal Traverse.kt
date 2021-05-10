package leetcode.normal

class Solution498 {
    fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
        if (matrix.isEmpty()) {
            return intArrayOf()
        }
        val n = matrix.size
        val m = matrix[0].size
        val ans = arrayListOf<Int>()
        for (sum in 0 until n + m) {
            val tmp = arrayListOf<Int>()
            for (i in 0..sum) {
                if (i < matrix.size && sum - i < matrix[0].size) {
                    tmp.add(matrix[i][sum - i])
                }
            }
            if (sum % 2 != 0) ans.addAll(tmp)
            else ans.addAll(tmp.reversed())
        }
        return ans.toIntArray()
    }
}