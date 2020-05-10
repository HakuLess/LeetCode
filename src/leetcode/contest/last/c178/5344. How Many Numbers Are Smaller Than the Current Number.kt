package leetcode.contest.last.c178

class Solution5344 {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val ans = ArrayList<Int>()
        nums.forEach { cur ->
            ans.add(nums.filter { it < cur }.size)
        }
        return ans.toIntArray()
    }
}