package leetcode.contest.cur.c168

class Solution5291 {
    fun findNumbers(nums: IntArray): Int {
        return nums.filter {
            it.toString().length % 2 == 0
        }.count()
    }
}