package leetcode.contest.cur.c186

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution5394()
//    s.findDiagonalOrder(listOf(
//            listOf(1, 2, 3),
//            listOf(4, 5, 6),
//            listOf(7, 8, 9)
//    )).print()

    s.findDiagonalOrder(listOf(
            listOf(1, 2, 3, 4, 5),
            listOf(6, 7),
            listOf(8),
            listOf(9, 10, 11),
            listOf(12, 13, 14, 15, 16)
    )).print()
}

class Solution5394 {
    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        val ans = arrayListOf<Int>()
        val map = HashMap<Int, ArrayList<Int>>()
        var max = 0
        for (i in nums.indices) {
            for (j in nums[i].indices) {
                map[i + j] = map.getOrDefault(i + j, arrayListOf())
                map[i + j]!!.add(0, nums[i][j])
                max = maxOf(max, i + j)
            }
        }
        for (i in 0..max) {
            ans.addAll(map[i]!!)
        }
        return ans.toIntArray()
    }
//    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
//        var max = 0
//        for (i in nums.indices) {
//            for (j in nums[i].indices) {
//                max = maxOf(max, i + j)
//            }
//        }
//        val seen = HashSet<Pair<Int, Int>>()
//
//        val ans = ArrayList<Int>()
//        var last = 0
//
//        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
//        queue.add(Pair(0, 0))
//        while (queue.isNotEmpty()) {
//            val size = queue.size
//            for (i in 0 until size) {
//                val item = queue.poll()
//                println("${item.first}, ${item.second}")
//                if (item in seen) {
//                    continue
//                }
//                seen.add(item)
//                if (item.first in nums.indices) {
//                    if (item.second in nums[item.first].indices) {
//                        ans.add(nums[item.first][item.second])
//                    }
//                } else {
//                    continue
//                }
//
//                if (item.first + item.second + 1 <= max) {
//                    queue.add(Pair(item.first + 1, item.second))
//                    queue.add(Pair(item.first, item.second + 1))
//                }
//            }
//        }
//        return ans.toIntArray()
//    }
}