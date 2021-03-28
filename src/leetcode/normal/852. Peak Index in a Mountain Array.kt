package leetcode.normal

class Solution852 {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        for (i in 0 until arr.size - 1) {
            if (arr[i] > arr[i + 1]) {
                return i
            }
        }
        return 0
    }
}