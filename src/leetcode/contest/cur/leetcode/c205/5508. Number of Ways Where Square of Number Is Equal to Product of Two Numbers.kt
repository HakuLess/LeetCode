package leetcode.contest.cur.leetcode.c205

import leetcode.contest.utils.print
import leetcode.contest.utils.printInt

fun main(args: Array<String>) {
    val s = Solution5508()
//    s.numTriplets(intArrayOf(7, 4), intArrayOf(5, 2, 8, 9)).print()
    s.numTriplets(IntArray(225) { 100000 }, IntArray(260) { 100000 }).print()
}

class Solution5508 {
    fun numTriplets(nums1: IntArray, nums2: IntArray): Int {
        val map1 = HashMap<Long, Int>()
        val map2 = HashMap<Long, Int>()
        for (i in nums1) {
            map1[i.toLong()] = map1.getOrDefault(i.toLong(), 0) + 1
        }
        for (i in nums2) {
            map2[i.toLong()] = map2.getOrDefault(i.toLong(), 0) + 1
        }

        var ans = 0
        for (i in nums1.indices) {
            val sq = nums1[i].toLong() * nums1[i].toLong()
            val map = HashMap(map2)
            for (j in nums2.indices) {
                map[nums2[j].toLong()] = map[nums2[j].toLong()]!! - 1
                if (sq % nums2[j] == 0L) {
                    ans += map.getOrDefault(sq / nums2[j], 0)
//                    println("$sq with ${nums2[j]} add key ${sq / nums2[j]} ${map.getOrDefault(sq / nums2[j], 0)}")
                }
            }
        }
        for (i in nums2.indices) {
            val sq = nums2[i].toLong() * nums2[i].toLong()
            val map = HashMap(map1)
            for (j in nums1.indices) {
                map[nums1[j].toLong()] = map[nums1[j].toLong()]!! - 1
                if (sq % nums1[j] == 0L) {
                    ans += map.getOrDefault(sq / nums1[j].toLong(), 0)
                }
            }
        }

        return ans
    }
}