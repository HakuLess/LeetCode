package leetcode

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val result = arrayListOf<Int>()
    nums1.distinct().forEach {
        if (it in nums2) {
            result.add(it)
        }
    }
    return result.toIntArray()
}