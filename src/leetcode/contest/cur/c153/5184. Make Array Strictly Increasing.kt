package leetcode.contest.cur.c153

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution5184()
//    s.makeArrayIncreasing(intArrayOf(1, 5, 3, 6, 7), intArrayOf(1, 3, 2, 4)).print()
//    s.makeArrayIncreasing(intArrayOf(1, 5, 3, 6, 7), intArrayOf(4, 3, 1)).print()
//    s.makeArrayIncreasing(intArrayOf(1, 5, 3, 6, 7), intArrayOf(1, 6, 3, 3)).print()
//    s.makeArrayIncreasing(intArrayOf(7, 6, 3, 0, 3), intArrayOf(9)).print()
    s.makeArrayIncreasing(intArrayOf(0, 11, 6, 1, 4, 3), intArrayOf(5, 4, 11, 10, 1, 0)).print()
}

/**
 * 可转化为 求 公共最长子序列
 * */
class Solution5184 {

    val seen = HashMap<Pair<Int, Int>, Int>()

    fun makeArrayIncreasing(arr1: IntArray, arr2: IntArray): Int {
        val set = TreeSet<Int>()
        arr2.forEach {
            set.add(it)
        }
        var ans = dfs(arr1, set, 0, 0)
        if (ans >= 3000) {
            ans = -1
        }
        return ans
    }

    private fun dfs(arr1: IntArray, set: TreeSet<Int>, index: Int, pre: Int): Int {
        if (index == arr1.size) {
            return 0
        }
        val p = Pair(index, pre)
        if (p in seen) {
            return seen[p]!!
        }
        val ans: Int
        if (index == 0) {
            ans = minOf(dfs(arr1, set, index + 1, arr1[0]), 1 + dfs(arr1, set, index + 1, set.first()))
            seen[p] = ans
            return ans
        }
        if (arr1[index] <= pre) {
            val change = set.ceiling(pre + 1)
            ans = if (change == null) {
                3000
            } else {
                1 + dfs(arr1, set, index + 1, change)
            }
            seen[p] = ans
            return ans
        } else {
            val change = set.ceiling(pre + 1)
            ans = if (change == null || change > arr1[index]) {
                dfs(arr1, set, index + 1, arr1[index])
            } else {
                minOf(1 + dfs(arr1, set, index + 1, change), dfs(arr1, set, index + 1, arr1[index]))
            }
            seen[p] = ans
            return ans
        }
    }
}