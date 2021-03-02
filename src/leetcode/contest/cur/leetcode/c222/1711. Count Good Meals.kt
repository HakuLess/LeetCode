package leetcode.contest.cur.leetcode.c222

import java.util.*
import kotlin.math.pow

class Solution1711 {
    fun countPairs(deliciousness: IntArray): Int {
        val targets = (0..21).map { 2.0.pow(it).toInt() }
        val map = HashMap<Int, Int>()
        var ans: Long = 0
        for (i in deliciousness.indices) {
            for (target in targets) {
                ans += map[target - deliciousness[i]] ?: 0
            }
            map[deliciousness[i]] = map.getOrDefault(deliciousness[i], 0) + 1
        }
        ans %= (1e9 + 7).toLong()
        return ans.toInt()
    }
}