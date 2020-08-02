package leetcode.contest.cur.leetcode.c200

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5477()
    s.minSwaps(arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 0)
    )).print()

    s.minSwaps(arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 1)
    )).print()
}

class Solution5477 {
    fun minSwaps(grid: Array<IntArray>): Int {
        val list = ArrayList<Int>()
        val n = grid.size
        for (i in grid.indices) {
            val row = grid[i]
            var cur = 0
            for (j in row.indices.reversed()) {
                if (row[j] == 0) {
                    cur++
                } else {
                    break
                }
            }
            list.add(cur)
        }
        list.joinToString(" ").print()
        var cur = n - 1
        var ans = 0
        for (i in list.indices) {
            if (list[i] >= cur) {
                cur--
                continue
            }
            var add = false
            for (j in i + 1 until list.size) {
                if (list[j] >= cur) {
                    ans += j - i
                    val temp = list[j]
                    list.removeAt(j)
                    list.add(i, temp)
                    add = true
                    cur--
                    break
                }
            }
            if (!add) return -1
        }
        return ans
    }
}