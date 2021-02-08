package leetcode.normal

import java.util.*

class Solution862 {
    fun shortestSubarray(A: IntArray, K: Int): Int {
        var sum = 0
        var ans = Int.MAX_VALUE
        val map = TreeMap<Int, Int>()
        map[0] = -1
        for (i in A.indices) {
            sum += A[i]
            val entry = map.floorEntry(sum - K)
            if (entry != null)
                ans = minOf(ans, i - entry.value)
            while (map.size > 0 && map.lastKey() >= sum)
                map.pollLastEntry()
            map[sum] = i
        }
        return if (ans == Int.MAX_VALUE) -1 else ans
    }
}