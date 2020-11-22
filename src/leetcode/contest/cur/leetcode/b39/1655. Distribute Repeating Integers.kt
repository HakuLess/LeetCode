package leetcode.contest.cur.leetcode.b39

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1655()
    s.canDistribute(intArrayOf(1, 1, 2, 3), intArrayOf(2, 2)).print()
    s.canDistribute(intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 26, 26, 27, 27, 28, 28, 29, 29, 30, 30, 31, 31, 32, 32, 33, 33, 34, 34, 35, 35, 36, 36, 37, 37, 38, 38, 39, 39, 40, 40, 41, 41, 42, 42, 43, 43, 44, 44, 45, 45, 46, 46, 47, 47, 48, 48, 49, 49, 50, 50),
            intArrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2, 3)).print()
}

class Solution1655 {
    fun canDistribute(nums: IntArray, quantity: IntArray): Boolean {
        val map = HashMap<Int, Int>()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        val cur = ArrayList<Int>()
        map.forEach { i, i2 ->
            cur.add(i2)
        }
        val st = cur.toIntArray()
        val seen = HashMap<String, Boolean>()
        fun dfs(cur: IntArray, index: Int): Boolean {
            cur.sortDescending()
            val key = "${cur.joinToString()}: $index"
            if (key in seen) {
                return seen[key]!!
            }
            if (index !in quantity.indices) {
                return true
            }
            var ans = false
            for (i in cur.indices) {
                if (cur[i] >= quantity[index]) {
                    val clone = cur.clone()
                    clone[i] -= quantity[index]
                    ans = ans or dfs(clone, index + 1)
                    if (ans) return true
                }
            }
            return ans.also {
                seen[key] = it
            }
        }
        return dfs(st, 0)
    }
}