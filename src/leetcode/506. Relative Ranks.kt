package leetcode

class Solution506 {
    fun findRelativeRanks(nums: IntArray): Array<String> {
        val sort = nums.sortedDescending()
        val ans = arrayListOf<String>()
        nums.forEach {
            when (it) {
                sort[0] -> ans.add("Gold Medal")
                sort[1] -> ans.add("Silver Medal")
                sort[2] -> ans.add("Bronze Medal")
                else -> ans.add((sort.indexOf(it) + 1).toString())
            }
        }

        return ans.toTypedArray()
    }
}