package leetcode.normal

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solution218()
    s.getSkyline(arrayOf(
            intArrayOf(2, 9, 10),
            intArrayOf(3, 7, 15),
            intArrayOf(5, 12, 12),
            intArrayOf(15, 20, 10),
            intArrayOf(19, 24, 8)
    )).forEach {
        it.toIntArray().print()
    }

    s.getSkyline(arrayOf(
            intArrayOf(0, 2147483647, 2147483647)
    )).forEach {
        it.toIntArray().print()
    }
}

class Solution218 {
    fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
        if (buildings.isEmpty()) {
            return emptyList()
        }
        val points = ArrayList<Pair<Int, Int>>()
        buildings.forEach {
            points.add(Pair(it[0], -it[2]))
            points.add(Pair(it[1], it[2]))
        }
        points.sortWith(compareBy({ it.first }, { it.second }))
        val pq = PriorityQueue<Int>() { a, b ->
            b - a
        }
        val ans = ArrayList<List<Int>>()
        var last = listOf(0, 0)
        for (p in points) {
            if (p.second < 0) pq.offer(-p.second)
            else pq.remove(p.second)
            val max = pq.peek() ?: 0
            if (last[1] != max) {
                last = listOf(p.first, max)
                ans.add(last)
            }
        }
        return ans
    }

//    fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
//        if (buildings.isEmpty()) {
//            return emptyList()
//        }
//        var list = arrayListOf<Int>()
//        buildings.forEach {
//            list.add(it[0])
//            list.add(it[0] + 1)
//            list.add(it[0] - 1)
//            list.add(it[1])
//            list.add(it[1] + 1)
//            list.add(it[1] - 1)
//        }
//        list.add(0)
//        list.removeAll { it < 0 }
//        list = ArrayList(list.distinct())
//        list.sort()
//        val disMap = HashMap<Int, Int>()
//        val map = HashMap<Int, Int>()
//        for (i in list.indices) {
//            disMap[list[i]] = i
//            map[i] = list[i]
//        }
//
////        list.size.print()
////        disMap.size.print()
////        disMap.printInt()
//
//        val last = disMap.size
//        val segmentTree = SegmentTree<Int>(IntArray(last).toTypedArray()) { a, b ->
//            maxOf(a, b)
//        }
//        buildings.forEach {
//            for (i in disMap[it[0]]!!..disMap[it[1]]!!) {
//                segmentTree.update(i, maxOf(it[2], segmentTree.get(i)))
//            }
//        }
//        val arr = segmentTree.arr.toIntArray()
////        arr.print()
//        val ans = arrayListOf<ArrayList<Int>>()
//        for (i in arr.indices) {
//            if (i == 0) {
//                if (arr[i] != 0) {
//                    ans.add(arrayListOf(map[i]!!, arr[i]))
//                }
//            } else {
//                if (arr[i] > arr[i - 1]) {
//                    ans.add(arrayListOf(map[i]!!, arr[i]))
//                } else if (arr[i] < arr[i - 1]) {
//                    ans.add(arrayListOf(map[i]!! - 1, arr[i]))
//                }
//            }
//        }
//        if (ans.lastOrNull()!![1] != 0)
//            ans.add(arrayListOf(buildings.maxByOrNull { it[1] }!![1], 0))
//        return ans
//    }
}