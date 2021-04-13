package leetcode.normal

import java.util.*

class Solution496 {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val len1 = nums1.size
        val len2 = nums2.size
        val stack = ArrayDeque<Int>()
        val map = HashMap<Int, Int>()
        for (i in 0 until len2) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
                map[stack.removeLast()] = nums2[i]
            }
            stack.addLast(nums2[i])
        }
        val res = IntArray(len1)
        for (i in 0 until len1) {
            res[i] = map.getOrDefault(nums1[i], -1)
        }
        return res
    }
}