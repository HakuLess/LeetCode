package leetcode.contest.cur.leetcode.c252

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5187()
    s.minimumPerimeter(8).print()
    s.minimumPerimeter(16).print()
    s.minimumPerimeter(1000000000).print()
}

class Solution5187 {
    fun minimumPerimeter(neededApples: Long): Long {
        var n = 0L
        var count = 0L
        while (count < neededApples) {
            n += 1
            count += 12 * n * n
        }
        return 8 * n
    }
}