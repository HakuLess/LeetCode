package leetcode.normal

class Solution228 {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) return listOf()
        val cur = intArrayOf(nums[0], nums[0])
        val ans = arrayListOf<String>()
        for (i in 1 until nums.size) {
            when {
                nums[i] == cur[1] + 1 -> {
                    cur[1] = nums[i]
                }
                else -> {
                    if (cur[0] == cur[1]) {
                        ans.add("${cur[0]}")
                    } else {
                        ans.add("${cur[0]}->${cur[1]}")
                    }
                    cur[0] = nums[i]
                    cur[1] = nums[i]
                }
            }
        }
        if (cur[0] == cur[1]) {
            ans.add("${cur[0]}")
        } else {
            ans.add("${cur[0]}->${cur[1]}")
        }
        return ans
    }
}