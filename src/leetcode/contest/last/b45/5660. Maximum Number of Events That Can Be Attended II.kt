package leetcode.contest.last.b45

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid


fun main(args: Array<String>) {
    val s = Solution5660()
//    s.maxValue("[[1,2,4],[3,4,3],[2,3,1]]".toGrid(), 2).print()
//    s.maxValue("[[1,2,4],[3,4,3],[2,3,10]]".toGrid(), 2).print()
//    s.maxValue("[[1,1,1],[2,2,2],[3,3,3],[4,4,4]]".toGrid(), 3).print()
//    s.maxValue("[[1,3,4],[2,4,1],[1,1,4],[3,5,1],[2,5,5]]".toGrid(), 3).print()
    s.maxValue("[[87,95,42],[3,42,37],[20,42,100],[53,84,80],[10,88,38],[25,80,57],[18,38,33]]".toGrid(), 3).print()
    s.maxValue("[[41,54,68],[28,84,88],[35,44,51],[10,64,36],[81,86,25],[6,51,80],[17,99,35],[8,86,22],[82,89,60],[61,73,96],[50,52,28]]".toGrid(), 111).print()
}

class Solution5660 {
    fun maxValue(events: Array<IntArray>, k: Int): Int {
        events.sortBy { it[1] }
        val n: Int = events.size
        val pre = IntArray(n)
        for (i in 1 until n) {
            for (j in i - 1 downTo 0) {
                if (events[i][0] <= events[j][1]) continue
                pre[i] = j + 1
                break
            }
        }
        val dp = Array(n + 1) { IntArray(k + 1) }
        for (i in 1..n)
            for (j in 1..k)
                dp[i][j] = maxOf(dp[i - 1][j], dp[pre[i - 1]][j - 1] + events[i - 1][2])
        return dp[n][k]
    }

//    fun maxValue(events: Array<IntArray>, k: Int): Int {
//        events.sortBy { it[1] }
//        var cur = TreeMap<Int, Int>()
//        cur[0] = 0
//        for (L in 1..k) {
//            val next = TreeMap<Int, Int>()
//            next[0] = 0
//            for ((start, end, v) in events) {
//                val key = cur.floorKey(start - 1)
//                next[end] = maxOf(cur[key]!! + v, next[next.floorKey(end)]!!)
//            }
//            cur = next
//        }
//        return cur.values.maxOrNull()!!
//    }
}
