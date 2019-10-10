package leetcode.contest.cur.c157

import leetcode.contest.utils.print
import leetcode.contest.utils.printInt

fun main(args: Array<String>) {
    val s = Solution5214()
    s.longestSubsequence(intArrayOf(1, 2, 3, 4), 1).print()
    s.longestSubsequence(intArrayOf(1, 3, 5, 7), 1).print()
    s.longestSubsequence(intArrayOf(1, 5, 7, 8, 5, 3, 4, 2, 1), -2).print()
    s.longestSubsequence(intArrayOf(4, 12, 10, 0, -2, 7, -8, 9, -9, -12, -12, 8, 8), 0).print()
    s.longestSubsequence(intArrayOf(7, -2, 8, 10, 6, 18, 9, -8, -5, 18, 13, -6, -17, -1, -6, -9, 9, 9), 1).print()
}

class Solution5214 {
    fun longestSubsequence(arr: IntArray, difference: Int): Int {
        val map = hashMapOf<Int, Int>()
        var ans = 1
        for (i in 0 until arr.size) {
            if (map.containsKey(arr[i] - difference)) {
                map[arr[i]] = map[arr[i] - difference]!! + 1
            } else {
                map[arr[i]] = 1
            }
            ans = maxOf(ans, map[arr[i]]!!)
        }
//        map.printInt()
        return ans
    }
}