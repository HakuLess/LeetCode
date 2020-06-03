package leetcode.normal

import leetcode.contest.utils.print

/**
 * Created by HaKu on 2018/9/18.
 */
fun main(args: Array<String>) {
    val s = Solution15()
    val source = arrayListOf(-1, 0, 1, 2, -1, -4).toIntArray()
    s.threeSum(source).print()
}

class Solution15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = hashSetOf<List<Int>>()
        nums.sort()
        for (index in nums.indices) {
            val it = nums[index]
            if (it > 0)
                return result.toMutableList()
            if (index > 0 && nums[index - 1] == it)
                continue
            var left = index + 1
            var right = nums.size - 1
            val target = -it
            while (left < right) {
                if (it + nums[left] > 0) {
                    break
                }
                when {
                    nums[left] + nums[right] < target -> left++
                    nums[left] + nums[right] == target -> {
                        result.add(arrayListOf(nums[left], nums[right], -target).sorted())
                        left++
                        right--
                    }
                    else -> right--
                }
            }
        }
        return result.toMutableList()
    }
}