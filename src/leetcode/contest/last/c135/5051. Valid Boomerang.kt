package leetcode.contest.last.c135

fun main(args: Array<String>) {
    val s = Solution5051()
    s.isBoomerang(
            arrayOf(intArrayOf(80, 32),
                    intArrayOf(46, 32),
                    intArrayOf(59, 32)
            ))
}

class Solution5051 {
    fun isBoomerang(points: Array<IntArray>): Boolean {
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[2][1] - points[0][1]) * (points[1][0] - points[0][0])
    }
}