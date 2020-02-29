package leetcode.contest.last.c168

import java.util.*
import kotlin.collections.HashMap

class Solution5292 {
    fun isPossibleDivide(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        val sortedMap: SortedMap<Int, Int> = map.toSortedMap()
        while (sortedMap.isNotEmpty()) {
            val s = sortedMap.firstKey()
            for (i in 0 until k) {
                if (sortedMap.containsKey(s + i)) {
                    sortedMap[s + i] = sortedMap[s + i]!! - 1
                    if (sortedMap[s + i] == 0) {
                        sortedMap.remove(s + i)
                    }
                } else {
                    return false
                }
            }
        }
        return true
    }
}