package leetcode.contest.cur.leetcode.c240

class Solution5751 {
    fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        var ans = 0
        var i = 0
        var j = 0
        while (i in nums1.indices && j in nums2.indices) {
            j = maxOf(j, i)
            while (j in nums2.indices && nums2[j] >= nums1[i]) {
                ans = maxOf(ans, j - i)
                j++
            }
            i++
        }
        return ans
    }
}