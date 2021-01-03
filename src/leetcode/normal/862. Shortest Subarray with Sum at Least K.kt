package leetcode.normal

import java.util.*

class Solution862 {
    fun shortestSubarray(A: IntArray, K: Int): Int {
        var sum = 0
        var result = Int.MAX_VALUE
        val map = TreeMap<Int, Int>()
        map[0] = -1
        for (i in A.indices) {
            sum += A[i]
            val floorEntry = map.floorEntry(sum - K)
            if (floorEntry != null && i - floorEntry.value < result)
                result = i - floorEntry.value
            while (map.size > 0 && map.lastKey() > sum)
                map.pollLastEntry()
            map[sum] = i
        }
        return if (result == Int.MAX_VALUE) -1 else result
    }
}