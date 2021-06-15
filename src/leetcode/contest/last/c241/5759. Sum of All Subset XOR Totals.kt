package leetcode.contest.last.c241

// https://www.geeksforgeeks.org/sum-xor-possible-subsets/
class Solution5759 {
    // 子集 subset 遍历
    fun subsetXORSum(nums: IntArray): Int {
        val n = nums.size
        val arr = IntArray(1 shl n)
        for (i in 0 until (1 shl n)) {
            for (j in 0 until n) {
                if (i and (1 shl j) != 0) {
                    arr[i] = arr[i] xor nums[j]
                }
            }
        }
        return arr.sum()
    }

//    fun subsetXORSum(nums: IntArray): Int {
//        var bits = 0
//        val n = nums.size
//        for (i in 0 until n) bits = bits or nums[i]
//        return bits * 2.0.pow(n - 1).toInt()
//    }
}
