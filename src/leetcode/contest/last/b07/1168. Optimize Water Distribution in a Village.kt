package leetcode.contest.last.b07

import leetcode.contest.utils.UFS
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1168()
    s.minCostToSupplyWater(3,
            intArrayOf(1, 2, 2),
            arrayOf(
                    intArrayOf(1, 2, 1),
                    intArrayOf(2, 3, 1)))
            .print()

    s.minCostToSupplyWater(5,
            intArrayOf(46012, 72474, 64965, 751, 33304),
            arrayOf(
                    intArrayOf(2, 1, 6719),
                    intArrayOf(3, 2, 75312),
                    intArrayOf(5, 3, 44918)
            )).print()
}

class Solution1168 {

    fun minCostToSupplyWater(n: Int, wells: IntArray, pipes: Array<IntArray>): Int {
        val ufs = UFS(n + 1)
        val pipe = arrayListOf<IntArray>()
        pipe.addAll(pipes)
        wells.forEachIndexed { index, i ->
            pipe.add(intArrayOf(0, index + 1, i))
        }
        var ans = 0
        pipe.sortBy { it[2] }
        pipe.forEach {
            if (ufs.union(it[0], it[1])) {
                println("add ${it[0]} & ${it[1]} is ${it[2]}")
                ans += it[2]
            }
        }
        return ans
    }
}