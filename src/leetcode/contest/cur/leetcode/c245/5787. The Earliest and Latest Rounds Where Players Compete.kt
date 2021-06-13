package leetcode.contest.cur.leetcode.c245

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5787()
//    s.earliestAndLatest(11, 2, 4).print()
//    s.earliestAndLatest(5, 1, 5).print()
    s.earliestAndLatest(7, 3, 4).print()
}

class Solution5787 {
    fun earliestAndLatest(n: Int, firstPlayer: Int, secondPlayer: Int): IntArray {
        fun step(min: Boolean): Int {
            var cur = arrayListOf<Int>()
            for (i in 1..n) cur.add(i)
            var step = 0
            while (cur.isNotEmpty()) {
                step++
                cur.joinToString().print()
                val next = arrayListOf<Int>()
                for (i in 0 until cur.size / 2) {
                    if (cur[i] == firstPlayer && cur[cur.lastIndex - i] == secondPlayer) return step
                    if (cur[i] == firstPlayer || cur[i] == secondPlayer) {
                        next.add(cur[i])
                    } else if (cur[cur.lastIndex - i] == firstPlayer || cur[cur.lastIndex - i] == secondPlayer) {
                        next.add(cur[cur.lastIndex - i])
                    } else if (cur[i] in firstPlayer..secondPlayer && cur[cur.lastIndex - i] in firstPlayer..secondPlayer) {
                        next.add(cur[i])
                    } else if (cur[i] !in firstPlayer..secondPlayer && cur[cur.lastIndex - i] in firstPlayer..secondPlayer) {
                        if (min) {
                            next.add(cur[cur.lastIndex - i])
                        } else {
                            next.add(cur[i])
                        }
                    } else if (cur[i] in firstPlayer..secondPlayer && cur[cur.lastIndex - i] !in firstPlayer..secondPlayer) {
                        if (min) {
                            next.add(cur[i])
                        } else {
                            next.add(cur[cur.lastIndex - i])
                        }
                    } else {
                        if ((1..100).random() >= 50) {
                            next.add(cur[i])
                        } else {
                            next.add(cur[cur.lastIndex - i])
                        }
                    }
                }
                if (cur.size % 2 == 1) {
                    next.add(cur[cur.size / 2])
                }
                cur = next
                cur.sort()
            }
            return -1
        }

        var a = 100
        var b = 0
        repeat(100) {
            val (p, q) = intArrayOf(step(true), step(false))
            a = minOf(a, p)
            b = maxOf(b, q)
        }
        return intArrayOf(a, b)
    }
}