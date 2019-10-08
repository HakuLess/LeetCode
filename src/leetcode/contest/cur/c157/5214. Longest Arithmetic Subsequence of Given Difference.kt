package leetcode.contest.cur.c157

import leetcode.contest.utils.print
import leetcode.contest.utils.printInt

fun main(args: Array<String>) {
    val s = Solution5214()
//    s.longestSubsequence(intArrayOf(1, 2, 3, 4), 1).print()
//    s.longestSubsequence(intArrayOf(1, 3, 5, 7), 1).print()
//    s.longestSubsequence(intArrayOf(1, 5, 7, 8, 5, 3, 4, 2, 1), -2).print()
//    s.longestSubsequence(intArrayOf(4, 12, 10, 0, -2, 7, -8, 9, -9, -12, -12, 8, 8), 0).print()
    s.longestSubsequence(intArrayOf(7, -2, 8, 10, 6, 18, 9, -8, -5, 18, 13, -6, -17, -1, -6, -9, 9, 9), 1).print()
}

class Solution5214 {
    fun longestSubsequence(arr: IntArray, difference: Int): Int {
        val map = hashMapOf<Int, Int>()
        var ans = 1
        for (i in 0 until arr.size) {
            var seen = false
            for (item in map) {
                if (item.key + difference == arr[i]) {
                    println("${arr[i]}: to ${item.value + 1}")
                    map.remove(item.key)
                    map[arr[i]] = item.value + 1
                    ans = maxOf(ans, item.value + 1)
                    seen = true
                    break
                }
            }
            if (!seen && arr[i] !in map) {
                map[arr[i]] = 1
            }
        }
        map.printInt()
        return ans
    }
}