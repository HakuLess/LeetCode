package leetcode.contest.cur.leetcode.c230

class Solution5691 {
    fun minOperations(nums1: IntArray, nums2: IntArray): Int {
        val a = nums1.sum()
        val b = nums2.sum()
        if (a == b) return 0
        val arr = arrayListOf<Int>()
        if (a < b) return minOperations(nums2, nums1)
        nums1.forEach { arr.add(it - 1) }
        nums2.forEach { arr.add(6 - it) }
        arr.sortDescending()
        var cur = a - b
        var i = 0
        while (cur > 0) {
            if (i !in arr.indices) return -1
            cur -= arr[i]
            i++
        }
        return i
    }
}