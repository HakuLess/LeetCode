package leetcode.contest.last.c195

import leetcode.contest.utils.print
import leetcode.contest.utils.printInt

fun main(args: Array<String>) {
    val s = Solution5449()
//    s.canArrange(intArrayOf(1, 2, 3, 4, 5, 10, 6, 7, 8, 9), 5).print()
    s.canArrange(intArrayOf(-1, 1, -2, 2, -3, 3, -4, 4), 3).print()
}

class Solution5449 {
    fun canArrange(arr: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()
        arr.forEach {
            var c = it % k
            if (c < 0) {
                c += k
            }
            map[c] = map.getOrDefault(c, 0) + 1
        }
        map.printInt()
        for (i in map.keys) {
            if (i == 0) {
                continue
            }
            if (map[i] == map.getOrDefault(k - i, 0)) {
                continue
            } else {
                return false
            }
        }
        if (map.containsKey(0) && map[0]!! % 2 != 0) return false
        if (k % 2 == 0 && map.getOrDefault(k / 2, 0) % 2 != 0) {
            return false
        }
        return true
    }
}