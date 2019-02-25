package leetcode

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val n = nums1.size + nums2.size
    return if (n % 2 == 1) {
        findKSmall(nums1, nums2, 0, 0, n / 2 + 1)
    } else {
        (findKSmall(nums1, nums2, 0, 0, n / 2) + findKSmall(nums1, nums2, 0, 0, n / 2 + 1)) / 2
    }
}

fun findKSmall(nums1: IntArray, nums2: IntArray, start1: Int, start2: Int, k: Int): Double {
    val m = nums1.size
    val n = nums2.size

    if (n - start2 < m - start1) return findKSmall(nums2, nums1, start2, start1, k)
    if (m - start1 == 0) return nums2[start2 + k - 1].toDouble()
    if (k == 1) return Math.min(nums1[start1], nums2[start2]).toDouble()

    val pos1 = Math.min(k / 2, m)
    val pos2 = k - pos1
    return when {
        nums1[start1 + pos1 - 1] < nums2[start2 + pos2 - 1] -> findKSmall(nums1, nums2, start1 + pos1, start2, k - pos1)
        nums1[start1 + pos1 - 1] > nums2[start2 + pos2 - 1] -> findKSmall(nums1, nums2, start1, start2 + pos2, k - pos2)
        else -> nums1[start1 + pos1 - 1].toDouble()
    }
}