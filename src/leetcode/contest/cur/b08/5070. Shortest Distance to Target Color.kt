package leetcode.contest.cur.b08

import leetcode.contest.utils.print
import kotlin.math.abs
import kotlin.math.min

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
        val map = HashMap<Int, ArrayList<Int>>()
        colors.forEachIndexed { index, it ->
            map[it] = map.getOrDefault(it, arrayListOf())
            map[it]!!.add(index)
        }

        val ans = arrayListOf<Int>()
        queries.forEach {
            var min = -1
            if (map[it[1]] == null) {
                ans.add(min)
            } else {
                val list = map[it[1]]!!
                val a = map[it[1]]?.binarySearch(it[0])!!
                println("${it[1]}, ${it[0]}, $a")
//                min = minOf(abs(it[0] - list[a]), abs(it[0] - list[a + 1]))
                ans.add(min)
            }
        }
        return ans.toIntArray()

    }
}