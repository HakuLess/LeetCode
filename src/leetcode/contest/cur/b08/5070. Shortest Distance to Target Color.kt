package leetcode.contest.cur.b08

import leetcode.contest.utils.print
import kotlin.math.min
import java.util.TreeSet
import java.util.HashMap


fun main(args: Array<String>) {
    val s = Solution5070()
    s.shortestDistanceColor(intArrayOf(1, 1, 2, 1, 3, 2, 2, 3, 3),
            arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 2),
                    intArrayOf(6, 1)
            )).print()

//    s.shortestDistanceColor(intArrayOf(1, 2),
//            arrayOf(
//                    intArrayOf(0, 3)
//            )).print()
}

class Solution5070 {
    fun shortestDistanceColor(colors: IntArray, queries: Array<IntArray>): IntArray {
        val map = HashMap<Int, TreeSet<Int>>()
        for (i in 1..3) {
            map[i] = TreeSet()
        }

        for (i in 0 until colors.size) {
            map[colors[i]]!!.add(i)
        }

        val res = arrayListOf<Int>()
        for (query in queries) {
            val i = query[0]
            val c = query[1]
            var dis = Integer.MAX_VALUE

            val floor = map[c]!!.floor(i)
            if (floor != null) dis = min(dis, i - floor)

            val ceil = map[c]!!.ceiling(i)
            if (ceil != null) dis = min(dis, ceil - i)

            res.add(if (dis != Integer.MAX_VALUE) dis else -1)
        }

        return res.toIntArray()
//        val map = HashMap<Int, ArrayList<Int>>()
//        colors.forEachIndexed { index, it ->
//            map[it] = map.getOrDefault(it, arrayListOf())
//            map[it]!!.add(index)
//        }
//
//        val res = arrayListOf<Int>()
//
//        for (query in queries) {
//            val index = query[0]
//            val target = query[1]
//            if (!map.containsKey(target)) {
//                res.add(-1)
//                continue
//            }
//            val indexes = map[target]!!
//            var bs = indexes.binarySearch(index)
//            if (bs >= 0) {
//                res.add(0)
//            } else {
//                if (bs == -1) {
//                    res.add(abs(indexes[0] - index))
//                } else {
//                    bs = -bs
//                    if (bs > indexes.size) {
//                        res.add(abs(indexes[indexes.size - 1] - index))
//                    } else {
//                        res.add(min(abs(indexes[bs - 1] - index), abs(indexes[bs - 2] - index)))
//                    }
//                }
//            }
//        }
//
//        return res.toIntArray()
    }
}