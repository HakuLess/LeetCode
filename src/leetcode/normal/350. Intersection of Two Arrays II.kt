package leetcode.normal

import leetcode.contest.utils.print

/**
 * Created by HaKu on 2018/9/28.
 */
fun main(args: Array<String>) {
    val s = Solution350()
    s.intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).print()
}

class Solution350 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val array1 = nums1.toMutableList()
        val array2 = nums2.toMutableList()
        val result = arrayListOf<Int>()
        array1.forEach {
            if (array2.contains(it)) {
                result.add(it)
                array2.remove(it)
            }
        }
        return result.toIntArray()
    }
}