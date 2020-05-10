package leetcode.contest.last.c180

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solution5359()
    s.maxPerformance(6, intArrayOf(2, 10, 3, 1, 5, 8), intArrayOf(5, 4, 3, 9, 7, 2), 2).print()
//    s.maxPerformance(6, intArrayOf(2, 10, 3, 1, 5, 8), intArrayOf(5, 4, 3, 9, 7, 2), 3).print()
//    s.maxPerformance(6, intArrayOf(2, 10, 3, 1, 5, 8), intArrayOf(5, 4, 3, 9, 7, 2), 4).print()
//    s.maxPerformance(8, intArrayOf(9, 9, 4, 6, 9, 7, 9, 8), intArrayOf(1, 9, 1, 9, 8, 1, 10, 1), 4).print()

}

class Solution5359 {

    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
        val mod = 1_000_000_007
        var max = 0L
        val list = ArrayList<Pair<Int, Int>>()
        for (i in 0 until n) {
            list.add(Pair(speed[i], efficiency[i]))
        }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        var sum = 0L
        list.sortedBy {
            -it.second
        }.forEach {
            pq.offer(it)
            sum += it.first
            if (pq.size > k) {
                sum -= pq.poll().first
            }
            max = maxOf(sum * it.second, max)
        }
        return (max % mod).toInt()
    }

//    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
//        var ans = 0L
//        val mod = 1_000_000_007
//        val seen = HashMap<Int, Long>()
//        var list = ArrayList<Pair<Int, Int>>()
//        for (i in 0 until n) {
//            list.add(Pair(speed[i], efficiency[i]))
//        }
//        list = ArrayList(list.sortedBy {
//            -it.first
//        })
//        for (i in 0 until n) {
//            if (list[i].second in seen) {
//                continue
//            }
//            val tmp = list.filter {
//                it.second >= list[i].second
//            }
//            val cur = ArrayList<Pair<Int, Int>>()
//            for (i in 0 until k) {
//                if (i in tmp.indices) {
//                    cur.add(tmp[i])
//                }
//            }
//
//            val result = cur.sumBy { it.first }.toLong() * tmp.minBy { it.second }!!.second.toLong()
//            seen[list[i].second] = result
//            ans = maxOf(result, ans)
//        }
//        return (ans % mod).toInt()
//    }
}
//class Solution5359 {
//    var max = 0L
//    var count = 0
//    val memo = HashMap<String, Long>()
//
//    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
//        count = k
//        val mod = 1_000_000_007
//        val list = ArrayList<Pair<Int, Int>>()
//        for (i in 0 until n) {
//            list.add(Pair(speed[i], efficiency[i]))
//        }
//        search(hashSetOf(), list, 0, Int.MAX_VALUE)
//        return (max % mod).toInt()
//    }
//
//    private fun search(seen: HashSet<Int>, list: ArrayList<Pair<Int, Int>>, speed: Int, efficiency: Int) {
//        val key = seen.joinToString(" ")
//        if (key in memo) {
//            return
//        }
//        max = maxOf(speed.toLong() * efficiency.toLong(), max)
//        if (seen.size != count) {
//            list.forEachIndexed { index, pair ->
//                if (index !in seen) {
//                    seen.add(index)
//                    search(seen, list, speed + pair.first, minOf(efficiency, pair.second))
//                    seen.remove(index)
//                }
//            }
//        }
//        val ans = speed.toLong() * efficiency.toLong()
//        memo[key] = ans
//    }
//}