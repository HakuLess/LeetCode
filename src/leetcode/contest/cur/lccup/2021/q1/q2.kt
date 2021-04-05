package leetcode.contest.cur.lccup.`2021`.q1

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solutionq2()
    s.orchestraLayout(4, 1, 2).print()
    s.orchestraLayout(4, 2, 2).print()
//    s.orchestraLayout(5, 1, 4).print()
//    s.orchestraLayout(5, 4, 4).print()
    s.orchestraLayout(3, 0, 2).print()
//    s.orchestraLayout(4, 1, 1).print()
}

class Solutionq2 {
    fun orchestraLayout(n: Int, xPos: Int, yPos: Int): Int {
        val x = (xPos + 1).toLong()
        val y = (yPos + 1).toLong()
        val q = minOf(minOf(x, y), minOf(n - x + 1, n - y + 1))
        var num = 0L
        num = if (x == y && x == q) {
            1
        } else if (y > x) {
            y + x - 2 * q + 1
        } else {
            4 * (n - 2 * q + 1) - (x + y - 2 * q) + 1
        }
        val ans = 2 * ((n - 1) + (n - 2 * (q - 1) + 1)) * (q - 1) + num
        if (ans % 9 == 0L) return 9
        return (ans % 9).toInt()
    }

//    fun orchestraLayout(n: Int, x: Int, y: Int): Int {
//        var top = 0
//        var bottom = n - 1
//        var left = 0
//        var right = n - 1
//        var ans = -1
//        fun dfs(dir: Int, a: Int, b: Int, cur: Int) {
//            if (ans != -1) return
//            when (dir) {
//                0 -> {
//                    top++
//                    if (x == a) ans = (cur + y - b) % 9
//                    dfs(1, a, right, (cur + right - b) % 9)
//                }
//                1 -> {
//                    right--
//                    if (y == b) ans = (cur + x - a) % 9
//                    dfs(2, bottom, b, (cur + bottom - a) % 9)
//                }
//                2 -> {
//                    bottom--
//                    if (x == a) ans = (cur + b - y) % 9
//                    dfs(3, left, b, (cur + a - left) % 9)
//                }
//                3 -> {
//                    left++
//                    if (y == b) ans = (cur + a - x) % 9
//                    dfs(0, a, top, (cur + b - top) % 9)
//                }
//            }
//        }
//        dfs(0, 0, 0, 0)
//        return ans + 1
//    }
}