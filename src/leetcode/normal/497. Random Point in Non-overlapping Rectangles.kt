package leetcode.normal

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution497(arrayOf(
            intArrayOf(82918473, -57180867, 82918476, -57180863),
            intArrayOf(83793579, 18088559, 83793580, 18088560),
            intArrayOf(66574245, 26243152, 66574246, 26243153),
            intArrayOf(72983930, 11921716, 72983934, 11921720)
    ))
    s.pick()
}

class Solution497(private val rects: Array<IntArray>) {

    private fun getIndex(): Int {
        var sum = 0
        for (i in rects.indices) {
            val rect = rects[i]
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1)
        }
        val random = Random().nextInt(sum + 1)

        sum = 0
        for (i in rects.indices) {
            val rect = rects[i]
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1)
            if (sum >= random) {
                println("$sum : $i $random")
                return i
            }
        }
        return rects.lastIndex
    }

    fun pick(): IntArray {
        val index = getIndex()
        val rect = rects[index]

        val xl = rect[0]
        val yl = rect[1]
        val xr = rect[2]
        val yr = rect[3]

        val x = Random().nextInt(xr - xl + 1) + xl
        val y = Random().nextInt(yr - yl + 1) + yl
        return intArrayOf(x, y)
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(rects)
 * var param_1 = obj.pick()
 */