package leetcode.contest.cur.leetcode.b38

class Solution5539 {
    fun frequencySort(nums: IntArray): IntArray {
        return nums.sortedWith(compareBy(
                { cur -> nums.count { it == cur } }, { -it })).toIntArray()
    }
}