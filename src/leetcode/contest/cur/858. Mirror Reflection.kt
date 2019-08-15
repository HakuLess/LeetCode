package leetcode.contest.cur

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution858()
    s.mirrorReflection(4, 3).print()
}

class Solution858 {
    fun mirrorReflection(p: Int, q: Int): Int {
        val map = hashMapOf<Pair<Int, Int>, Int>()
        map[Pair(p, 0)] = 0
        map[Pair(p, p)] = 1
        map[Pair(0, p)] = 2
        var cur = Pair(0, 0)
        var ori = Pair(p, q)
        while (cur !in map) {
            println("${cur.first}, ${cur.second}")
            var x = cur.first
            var y = cur.second
            x += ori.first
            y += ori.second
            val fir = if (x == 0) { p } else { -p }
            var sec = ori.second
            when {
                y > p -> {
                    y = 2 * p - y
                    sec = -q
                }
                y < 0 -> {
                    y = -y
                    sec = q
                }
            }
            ori = Pair(fir, sec)
            cur = Pair(x, y)
        }
        return map[cur]!!
    }
}