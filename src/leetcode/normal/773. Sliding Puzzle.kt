package leetcode.normal

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
//    arrayOf(
//            intArrayOf(4, 1, 2),
//            intArrayOf(5, 0, 3)
//    ).toFormatString().print()
    val s = Solution773()
    s.slidingPuzzle(
            arrayOf(
                    intArrayOf(4, 1, 2),
                    intArrayOf(5, 0, 3)
            )
    ).print()
}

fun Array<IntArray>.toFormatString(): String {
    var ans = ""
    this.forEach {
        ans += it.joinToString(",")
        ans += ","
    }
    return ans
}

class Solution773 {
    val seen = hashSetOf<String>()

    fun slidingPuzzle(board: Array<IntArray>): Int {
        val queue: Queue<Array<IntArray>?> = LinkedList()
        queue.add(board)
        var step = -1
        while (queue.isNotEmpty()) {
            val size = queue.size
            step++
            if (step > 100) {
                return -1
            }
            for (i in 0 until size) {
                val item = queue.poll() ?: continue
                if (item.toFormatString() == "1,2,3,4,5,0,") {
                    return step
                }
                if (item.toFormatString() !in seen) {
                    queue.add(moveZero(0, item))
                    queue.add(moveZero(1, item))
                    queue.add(moveZero(2, item))
                    queue.add(moveZero(3, item))
                    seen.add(item.toFormatString())
                }
            }
        }
        return -1
    }

    private fun moveZero(ori: Int, cur: Array<IntArray>): Array<IntArray>? {
        var y = cur[0].indexOf(0)
        var x = 0
        if (y == -1) {
            x = 1
            y = cur[1].indexOf(0)
        }
        val ans = Array(2) { intArrayOf(0, 0, 0) }
        for (i in 0..1) {
            for (j in 0..2) {
                ans[i][j] = cur[i][j]
            }
        }

        var tx = x
        var ty = y
        when (ori) {
            0 -> {
                if (tx > 0) {
                    tx--
                } else {
                    return null
                }
            }
            1 -> {
                if (tx < 1) {
                    tx++
                } else {
                    return null
                }
            }
            2 -> {
                if (ty > 0) {
                    ty--
                } else {
                    return null
                }
            }
            3 -> {
                if (ty < 2) {
                    ty++
                } else {
                    return null
                }
            }
        }
        val temp = ans[tx][ty]
        ans[tx][ty] = 0
        ans[x][y] = temp
        return ans
    }
}