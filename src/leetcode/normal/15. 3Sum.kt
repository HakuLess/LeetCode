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
        val sorted = nums.sorted()

        sorted.forEachIndexed { index, it ->
            if (it > 0)
                return result.toMutableList()
            var left = index + 1
            var right = sorted.size - 1
            val target = -it
            while (left < right) {
                if (it + sorted[left] > 0) {
                    break
                }
                when {
                    sorted[left] + sorted[right] < target -> left++
                    sorted[left] + sorted[right] == target -> {
                        result.add(arrayListOf(sorted[left], sorted[right], -target).sorted())
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