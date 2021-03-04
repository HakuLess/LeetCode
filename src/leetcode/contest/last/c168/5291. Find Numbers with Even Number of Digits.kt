package leetcode.contest.last.c168

class Solution5291 {
    fun findNumbers(nums: IntArray): Int {
        return nums.asSequence().filter {
            it.toString().length % 2 == 0
        }.count()
    }
}