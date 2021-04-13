package leetcode.contest.cur.leetcode.c236

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5728()
    s.minSideJumps(intArrayOf(0, 1, 2, 3, 0)).print()
}

class Solution5728 {
    fun minSideJumps(obstacles: IntArray): Int {
        var cur = intArrayOf(1, 0, 1)
        for (i in 1 until obstacles.size) {
            val next = intArrayOf(0, 0, 0)
            if (obstacles[i] == 0) continue
            for (j in 0..2) {
                if (obstacles[i] == j + 1) {
                    next[j] = Int.MAX_VALUE / 2
                } else {
                    next[j] = if (obstacles[i - 1] == j + 1) {
                        Int.MAX_VALUE / 2
                    } else {
                        val clone = ArrayList(cur.map { it + 1 })
                        clone[j]--
                        clone.min()!!
                    }
                }
            }
            cur = next
        }
        return cur.min()!!
    }
}