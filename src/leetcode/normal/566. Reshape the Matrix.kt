package leetcode.normal

class Solution566 {
    fun matrixReshape(nums: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val n = nums.size
        val m = nums[0].size
        if (r * c != n * m) {
            return nums
        }
        val res = Array(r) { IntArray(c) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                val idx = i * m + j
                val ii = idx / c
                val jj = idx % c
                res[ii][jj] = nums[i][j]
            }
        }
        return res
    }
}