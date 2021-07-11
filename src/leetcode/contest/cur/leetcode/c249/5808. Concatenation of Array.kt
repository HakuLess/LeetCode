package leetcode.contest.cur.leetcode.c249

class Solution5808 {
    fun getConcatenation(nums: IntArray): IntArray {
        val arr = ArrayList<Int>()
        arr.addAll(nums.toList())
        arr.addAll(nums.toList())
        return arr.toIntArray()
    }
}