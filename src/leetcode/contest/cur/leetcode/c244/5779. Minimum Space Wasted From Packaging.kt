package leetcode.contest.cur.leetcode.c244

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution5779()
    s.minWastedSpace(intArrayOf(1, 8, 9, 2, 7), "[[9],[10,6],[2]]".toGrid()).print()
}

class Solution5779 {
    fun minWastedSpace(packages: IntArray, boxes: Array<IntArray>): Int {
        val mod = 1000000007L
        boxes.forEach {
            it.sort()
        }
        packages.sort()
        var max = packages.last()
        boxes.forEach {
            max = maxOf(max, it.last())
        }
        val map = ArrayList<Pair<Long, Long>>()
        map.add(Pair(0, 0))
        val arr = ArrayList(packages.toList())
        var tmp = 0L
        var c = 0L
        for (i in 1..max) {
            while (arr.isNotEmpty() && arr[0] <= i) {
                tmp += arr[0]
                arr.removeAt(0)
                c++
            }
            map.add(Pair(tmp, c))
        }
//        map.joinToString().print()

        var ans = Long.MAX_VALUE
        for (i in boxes.indices) {
            val it = boxes[i]
            if (it.last() < packages.last()) {
                continue
            }
            var tmp = 0L
            for (j in it.indices) {
//                println("$j ${map[it[j]]}")
                if (j == 0) {
                    tmp += map[it[j]].second * it[j] - map[it[j]].first
                } else {
                    tmp += (map[it[j]].second - map[it[j - 1]].second) * it[j] - (map[it[j]].first - map[it[j - 1]].first)
                }
            }
//            println("${it.joinToString()} with $tmp")
            ans = minOf(ans, tmp)
        }
        return if (ans == Long.MAX_VALUE) -1 else (ans % mod).toInt()
    }
}