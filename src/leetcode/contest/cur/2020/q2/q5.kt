package leetcode.contest.cur.`2020`.q2

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solutionq5()
//    s.visitOrder(arrayOf(
//            intArrayOf(1, 1),
//            intArrayOf(1, 4),
//            intArrayOf(3, 2),
//            intArrayOf(2, 1)
//    ), "LL").print()

    s.visitOrder(arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 4),
            intArrayOf(3, 3),
            intArrayOf(2, 1)
    ), "LR").print()
}

class Solutionq5 {

    var p = arrayOf(intArrayOf())
    var d = ""
    var a = arrayListOf<Int>()

    fun visitOrder(points: Array<IntArray>, direction: String): IntArray {
        p = points
        d = direction
        for (i in points.indices) {
            helper(i, null, arrayListOf(i))
        }
        println(a.size)
        return a.toIntArray()
    }

    private fun helper(cur: Int, pre: Int?, ans: ArrayList<Int>) {
//        println("${p.size} ans ${ans.size}")
        if (a.size == p.size) {
            return
        }
        if (ans.size == p.size) {
            a = ArrayList(ans)
            println("size : ${a.size}")
            return
        }
        for (i in p.indices) {
            if (i in ans) {
                continue
            }
            if (pre == null) {
                ans.add(i)
                helper(i, cur, ans)
                ans.remove(i)
            } else {
                val index = ans.size - 2
                val dir = d[index]

                val p1 = Point(p[pre][0], p[pre][1])
                val p2 = Point(p[cur][0], p[cur][1])
                val p3 = Point(p[i][0], p[i][1])

                if (dir == 'L') {
                    if (directionOfPoint(p1, p2, p3) == RIGHT) {
                        ans.add(i)
                        helper(i, cur, ans)
                        ans.remove(i)
                    }
                } else if (dir == 'R') {
                    if (directionOfPoint(p1, p2, p3) == LEFT) {
                        ans.add(i)
                        helper(i, cur, ans)
                        ans.remove(i)
                    }
                }
            }
        }
    }

    class Point(var x: Int, var y: Int) {}

    // constant integers for directions
    var RIGHT = 1
    var LEFT: Int = -1
    var ZERO: Int = 0

    fun directionOfPoint(A: Point, B: Point, P: Point): Int {
//        println("${A.x} ${A.y}")
//        println("${B.x} ${B.y}")
//        println("${P.x} ${P.y}")

        // subtracting co-ordinates of point A
        // from B and P, to make A as origin
        B.x -= A.x
        B.y -= A.y
        P.x -= A.x
        P.y -= A.y
        // Determining cross Product
        val cross_product = B.x * P.y - B.y * P.x
        val ans = when {
            cross_product > 0 -> RIGHT
            cross_product < 0 -> LEFT
            else -> ZERO
        }
//        println("ans is $ans")
        return ans
    }
}