package leetcode.contest.last.c222

import leetcode.contest.utils.lis

class Solution5644 {
    fun minOperations(target: IntArray, arr: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (i in target.indices) {
            map[target[i]] = i
        }
        return target.size - arr.map {
            map.getOrDefault(it, -1)
        }.filter { it != -1 }.toIntArray().lis()
    }
}