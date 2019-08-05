package leetcode.contest.last.b05

import leetcode.UFS
import leetcode.print

fun main(args: Array<String>) {
    val s = Solution5036()
//    s.minimumCost(3,
//            arrayOf(
//                    intArrayOf(1, 2, 5),
//                    intArrayOf(1, 3, 6),
//                    intArrayOf(2, 3, 1)
//            )).print()
//
//    s.minimumCost(4,
//            arrayOf(
//                    intArrayOf(1, 2, 3),
//                    intArrayOf(3, 4, 4)
//            )).print()
//
//    s.minimumCost(4,
//            arrayOf(
//                    intArrayOf(1, 2, 1),
//                    intArrayOf(1, 3, 2),
//                    intArrayOf(3, 4, 4),
//                    intArrayOf(1, 4, 3)
//            )).print()

    s.minimumCost(5,
            arrayOf(
                    intArrayOf(1, 2, 3267),
                    intArrayOf(2, 3, 25910),
                    intArrayOf(1, 4, 30518)
            )).print()

    s.minimumCost(4,
            arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(3, 4, 4)
            )).print()
}

class Solution5036 {

    fun minimumCost(N: Int, connections: Array<IntArray>): Int {
        val ufs = UFS(N)
        var ans = 0
        var step = 0
        connections.sortWith(compareBy { it[2] })
        connections.forEach {
            if (ufs.union(it[0] - 1, it[1] - 1)) {
                ans += it[2]
                step++
            }
        }
        return if (step == N - 1) {
            return ans
        } else {
            -1
        }
    }
}
