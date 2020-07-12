package leetcode.contest.cur.leetcode.c197

import leetcode.contest.utils.print
import kotlin.math.abs
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val s = Solution5463()
    s.getMinDistSum(arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(1, 2),
            intArrayOf(2, 1)
    )).print()

//    [[0,1],[3,2],[4,5],[7,6],[8,9],[11,1],[2,12]]
    s.getMinDistSum(arrayOf(
            intArrayOf(0, 1),
            intArrayOf(3, 2),
            intArrayOf(4, 5),
            intArrayOf(7, 6),
            intArrayOf(8, 9),
            intArrayOf(11, 1),
            intArrayOf(2, 12)
    )).print()
}

// tag: Geometric Median
class Solution5463 {
    fun getMinDistSum(positions: Array<IntArray>): Double {

        val test_point = arrayOf<Point>(Point(-1.0, 0.0), Point(0.0, 1.0), Point(1.0, 0.0), Point(0.0, -1.0))
        var lower_limit = 0.00001
        val n = positions.size
        val arr = Array<Point?>(positions.size) { null }
        for (i in positions.indices) {
            arr[i] = Point(positions[i][0].toDouble(), positions[i][1].toDouble())
        }
        val current_point: Point = Point(0.0, 0.0)
        for (i in 0 until n) {
            current_point.x += arr[i]!!.x
            current_point.y += arr[i]!!.y
        }
        current_point.x /= n
        current_point.y /= n
        var min = distSum(current_point, arr.map { it!! }.toTypedArray(), n)
        var k = 0
        while (k < n) {
            for (i in 0 until n) {
                if (i == k) continue
                val new = Point(arr[i]!!.x, arr[i]!!.y)
                val newed = distSum(new, arr.map { it!! }.toTypedArray(), n)
                if (newed < min) {
                    min = newed
                    current_point.x = new.x
                    current_point.y = new.y
                }
            }
            k++
        }

        var test_distance: Double = 100.0
        var flag = 0
        while (test_distance > lower_limit) {
            flag = 0
            for (i in 0 until 4) {
                val np = Point(current_point.x + test_distance * test_point[i].x, current_point.y + test_distance * test_point[i].y)
                var newd = distSum(np, arr.map { it!! }.toTypedArray(), n)
                if (newd < min) {
                    min = newd
                    current_point.x = np.x
                    current_point.y = np.y
                    flag = 1
                    break
                }
            }

            if (flag == 0) {
                test_distance /= 2
            }
        }

        return min
    }

    private fun distSum(p: Point, arr: Array<Point>, n: Int): Double {
        var sum = 0.0
        for (i in 0 until n) {
            val distx = abs(arr[i].x - p.x)
            val disty = abs(arr[i].y - p.y)
            sum += sqrt((distx * distx) + (disty * disty))
        }
        return sum
    }
}

data class Point(var x: Double, var y: Double)