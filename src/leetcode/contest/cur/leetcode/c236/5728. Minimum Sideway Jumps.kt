package leetcode.contest.cur.leetcode.c236

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5728()
    s.minSideJumps(intArrayOf(0, 1, 2, 3, 0)).print()
}

class Solution5728 {
    fun minSideJumps(obstacles: IntArray): Int {
        var a1 = 1
        var a2 = 0
        var a3 = 1
        for (i in 1 until obstacles.size) {
            var n1 = 0
            var n2 = 0
            var n3 = 0
            when (obstacles[i]) {
                1 -> {
                    n1 = Int.MAX_VALUE / 2
                    n2 = if (obstacles[i - 1] == 2) {
                        Int.MAX_VALUE / 2
                    } else {
                        minOf(a2, a1 + 1, a3 + 1)
                    }
                    n3 = if (obstacles[i - 1] == 3) {
                        Int.MAX_VALUE / 2
                    } else {
                        minOf(a3, a1 + 1, a2 + 1)
                    }
                }
                2 -> {
                    n1 = if (obstacles[i - 1] == 1) {
                        Int.MAX_VALUE / 2
                    } else {
                        minOf(a1, a2 + 1, a3 + 1)
                    }
                    n2 = Int.MAX_VALUE / 2
                    n3 = if (obstacles[i - 1] == 3) {
                        Int.MAX_VALUE / 2
                    } else {
                        minOf(a3, a1 + 1, a2 + 1)
                    }
                }
                3 -> {
                    n1 = if (obstacles[i - 1] == 1) {
                        Int.MAX_VALUE / 2
                    } else {
                        minOf(a1, a2 + 1, a3 + 1)
                    }
                    n2 = if (obstacles[i - 1] == 2) {
                        Int.MAX_VALUE / 2
                    } else {
                        minOf(a2, a2 + 1, a3 + 1)
                    }
                    n3 = Int.MAX_VALUE / 2
                }
                0 -> {
                    n1 = a1
                    n2 = a2
                    n3 = a3
                }
            }
            a1 = n1
            a2 = n2
            a3 = n3
            println("$i: $a1 $a2 $a3")
        }
        return intArrayOf(a1, a2, a3).min()!!
    }
}