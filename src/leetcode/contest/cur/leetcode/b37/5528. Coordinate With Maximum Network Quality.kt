package leetcode.contest.cur.leetcode.b37

import kotlin.math.floor
import kotlin.math.sqrt

class Solution5528 {
    fun bestCoordinate(towers: Array<IntArray>, radius: Int): IntArray {
        fun dis(x1: Int, y1: Int, x2: Int, y2: Int): Double {
            return sqrt(((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)).toDouble())
        }

        val ans = ArrayList<Triple<Int, Int, Double>>()
        towers.forEach {
            ans.add(Triple(it[0], it[1], it[2].toDouble()))
        }
        val n = towers.size
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i != j) {
                    val dis = dis(towers[i][0], towers[i][1], towers[j][0], towers[j][1])
                    if (dis <= radius) {
                        ans[i] = Triple(ans[i].first, ans[i].second, ans[i].third + floor(towers[j][2] / (1 + dis)))
                    }
                }
            }
        }
        return ans.sortedWith(compareBy({ -it.third }, { it.first })).first().let {
            intArrayOf(
                    it.first, it.second
            )
        }
    }
}