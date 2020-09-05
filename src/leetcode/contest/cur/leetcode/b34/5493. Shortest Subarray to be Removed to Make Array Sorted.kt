package leetcode.contest.cur.leetcode.b34

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5493()
    s.findLengthOfShortestSubarray(intArrayOf(1, 2, 3, 10, 4, 2, 3, 5)).print()
    s.findLengthOfShortestSubarray(intArrayOf(1)).print()
    s.findLengthOfShortestSubarray(intArrayOf(1, 2, 3)).print()
    s.findLengthOfShortestSubarray(intArrayOf(1, 3, 2, 4)).print()
    s.findLengthOfShortestSubarray(intArrayOf(13, 0, 14, 7, 18, 18, 18, 16, 8, 15, 20)).print()
    s.findLengthOfShortestSubarray(intArrayOf(10, 13, 17, 21, 15, 15, 9, 17, 22, 22, 13)).print()
}

class Solution5493 {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        val n = arr.size
        var r = n - 1
        while (r - 1 in arr.indices && arr[r] >= arr[r - 1]) {
            r--
        }
        var ans = r
        var i = 0
        var j = r
        while (i in arr.indices) {
            if (i - 1 in arr.indices && arr[i - 1] > arr[i]) break
            while (j < n && arr[j] < arr[i]) {
                ++j
            }
            ans = minOf(ans, j - i - 1)
            ++i
        }
        return maxOf(ans, 0)
    }
}