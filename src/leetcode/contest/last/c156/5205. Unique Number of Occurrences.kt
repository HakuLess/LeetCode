package leetcode.contest.last.c156

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5205()
    s.uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3)).print()
    s.uniqueOccurrences(intArrayOf(1, 2)).print()
    s.uniqueOccurrences(intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0)).print()
    s.uniqueOccurrences(intArrayOf(3, 5, -2, -3, -6, -6)).print()
}

class Solution5205 {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val map = HashMap<Int, Int>()
        arr.forEach {
            map[it] = map.getOrDefault(it, 0)
            map[it] = map[it]!! + 1
        }
        val set = hashSetOf<Int>()
        for (item in map) {
            if (item.value in set) {
                return false
            }
            set.add(item.value)
        }
        return true
    }
}