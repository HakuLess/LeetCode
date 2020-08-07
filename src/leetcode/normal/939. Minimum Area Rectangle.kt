package leetcode.normal

import java.util.*
import kotlin.collections.ArrayList


class Solution939 {
    fun minAreaRect(points: Array<IntArray>): Int {
        val rows = TreeMap<Int, ArrayList<Int>>()
        for (point in points) {
            val x = point[0]
            val y = point[1]
            rows.computeIfAbsent(x) { z: Int -> arrayListOf<Int>() }.add(y)
        }

        var ans = Int.MAX_VALUE
        val lastx = HashMap<Int, Int>()
        for (x in rows.keys) {
            val row = rows[x]!!
            row.sort()
            for (i in row.indices) for (j in i + 1 until row.size) {
                val y1 = row[i]
                val y2 = row[j]
                val code = 40001 * y1 + y2
                if (lastx.containsKey(code)) ans = minOf(ans, (x - lastx[code]!!) * (y2 - y1))
                lastx[code] = x
            }
        }

        return if (ans < Int.MAX_VALUE) ans else 0
    }
}