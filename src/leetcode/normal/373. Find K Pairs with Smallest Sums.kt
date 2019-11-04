package leetcode.normal

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution373()
//    s.kSmallestPairs(intArrayOf(1, 7, 11), intArrayOf(2, 4, 6), 20).print()
    s.kSmallestPairs(intArrayOf(1, 1, 2), intArrayOf(1, 2, 3), 2).print()
//    s.kSmallestPairs(intArrayOf(1, 7, 11), intArrayOf(2, 4, 6), 3).print()
}

class Solution373 {
//    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
//        if (nums1.isEmpty() || nums2.isEmpty() || k == 0) {
//            return emptyList()
//        }
//        val ans = ArrayList<List<Int>>()
//        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { -nums1[it.first] - nums2[it.second] })
//        for (i in nums1.indices) {
//            for (j in nums2.indices) {
//                pq.add(Pair(i, j))
//                if (pq.size > k) {
//                    pq.poll()
//                }
//            }
//        }
//
//        while (pq.isNotEmpty()) {
//            val it = pq.poll()
//            ans.add(listOf(nums1[it.first], nums2[it.second]))
//        }
//        return ans.reversed()
//    }

    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        if (nums1.isEmpty() || nums2.isEmpty()) {
            return emptyList()
        }
        val ans = ArrayList<List<Int>>()
        val queue = PriorityQueue<Pair<Int, Int>>(compareBy { nums1[it.first] + nums2[it.second] })
        queue.add(Pair(0, 0))
        val seen = HashSet<Pair<Int, Int>>()
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                ans.add(listOf(nums1[item.first], nums2[item.second]))
                if (ans.size == k) {
                    return ans
                }
                if (item.first < nums1.lastIndex && Pair(item.first + 1, item.second) !in seen) {
                    seen.add(Pair(item.first + 1, item.second))
                    queue.offer(Pair(item.first + 1, item.second))
                }
                if (item.second < nums2.lastIndex && Pair(item.first, item.second + 1) !in seen) {
                    seen.add(Pair(item.first, item.second + 1))
                    queue.offer(Pair(item.first, item.second + 1))
                }
            }
        }
        return ans
    }
}