package leetcode.contest.cur.leetcode.c200

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5478()
    s.maxSum(intArrayOf(2, 4, 5, 8, 10), intArrayOf(4, 6, 8, 9)).print()
}

class Solution5478 {
    fun maxSum(nums1: IntArray, nums2: IntArray): Int {
        val mod = 1000000007L
        val set = nums1.intersect(nums2.toSet())
        set.joinToString(" ").print()
        val seen = HashMap<Pair<Int, Int>, Long>()
        fun dfs(i: Int, j: Int): Long {
            println("$i, $j")
            if (Pair(i, j) in seen) return seen[Pair(i, j)]!!
            var ans = 0L
            if (j == -1) return ans
            if (i == 1) {
                ans = if (nums1[j] !in set) {
                    dfs(1, j - 1) + nums1[j]
                } else {
                    maxOf(dfs(1, j - 1), dfs(2, nums2.binarySearch(nums1[j]) - 1)) + nums1[j]
                }
            } else {
                ans = if (nums2[j] !in set) {
                    dfs(2, j - 1) + nums2[j]
                } else {
                    maxOf(dfs(2, j - 1), dfs(1, nums1.binarySearch(nums2[j]) - 1)) + nums2[j]
                }
            }
            seen[Pair(i, j)] = ans
            return ans
        }

        seen.forEach {
            println("${it.key} : ${it.value}")
        }
        return (maxOf(dfs(1, nums1.lastIndex), dfs(2, nums2.lastIndex)) % mod).toInt()
    }
}