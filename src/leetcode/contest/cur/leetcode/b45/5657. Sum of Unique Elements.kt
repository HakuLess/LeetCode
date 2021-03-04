package leetcode.contest.cur.leetcode.b45

class Solution5647 {
    fun sumOfUnique(nums: IntArray): Int {
        return nums.asSequence().filter { cur ->
            nums.count { it == cur } == 1
        }.sum()
    }
}