package leetcode.contest.cur.leetcode.c222

import java.util.*
import kotlin.math.pow

class Solution1711 {
    fun countPairs(deliciousness: IntArray): Int {
        val map = HashMap<Int, Int>()
        var ans: Long = 0
        for (i in deliciousness.indices) {
            for (j in 0..21) {
                val target = 2.0.pow(j).toInt()
                if (target - deliciousness[i] < 0) continue
                if (map.containsKey(target - deliciousness[i])) {
                    ans += map[target - deliciousness[i]]!!
                }
            }
            map[deliciousness[i]] = map.getOrDefault(deliciousness[i], 0) + 1
        }
        ans %= (1e9 + 7).toLong()
        return ans.toInt()
    }
}