package leetcode.contest.cur.leetcode.b53

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution5757()
//    s.getBiggestThree("[[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]]".toGrid()).print()
    s.getBiggestThree("[[20,17,9,13,5,2,9,1,5],[14,9,9,9,16,18,3,4,12],[18,15,10,20,19,20,15,12,11],[19,16,19,18,8,13,15,14,11],[4,19,5,2,19,17,7,2,2]]".toGrid()).print()
}

class Solution5757 {
    fun getBiggestThree(grid: Array<IntArray>): IntArray {
        val m = grid.size
        val n = grid[0].size
        fun valid(z: Pair<Int, Int>): Boolean {
            return z.first in 0 until m && z.second in 0 until n
        }

        val ts = TreeSet<Int>()

        fun cal(x1: Pair<Int, Int>, k: Int) {
            val set = HashSet<Pair<Int, Int>>()
            set.add(x1)
            for (i in 0..k) {
                set.add(Pair(x1.first + i, x1.second + i))
                set.add(Pair(x1.first + i, x1.second - i))
                set.add(Pair(x1.first + i + k, x1.second - k + i))
                set.add(Pair(x1.first + i + k, x1.second + k - i))
            }
            var t = 0
            set.forEach {
                t += grid[it.first][it.second]
            }
            ts.add(t)
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                for (k in 0 until maxOf(m, n)) {
                    val x1 = Pair(i, j)
                    val x2 = Pair(i + k, j + k)
                    val x3 = Pair(i + k, j - k)
                    val x4 = Pair(i + 2 * k, j)
                    if (valid(x1) && valid(x2) && valid(x3) && valid(x4)) {
                        cal(x1, k)
                    }
                }
            }
        }

        val ans = ArrayList<Int>()
        while (ans.size != 3 && ts.isNotEmpty()) {
            ans.add(ts.pollLast())
        }
        return ans.toIntArray()
    }
}