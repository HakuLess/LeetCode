package leetcode.contest.last.b51

class Solution5732 {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        arr.sort()
        arr[0] = 1
        for (i in 1 until arr.size) {
            arr[i] = minOf(arr[i], arr[i - 1] + 1)
        }
        return arr.last()
    }
}