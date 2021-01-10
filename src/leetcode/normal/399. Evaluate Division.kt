package leetcode.normal

import leetcode.contest.utils.TypedUFS
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution399()
    s.calcEquation(listOf(
            listOf("a", "b"),
            listOf("e", "f"),
            listOf("b", "e")
    ), doubleArrayOf(3.4, 1.4, 2.3),
            listOf(
                    listOf("a", "f")
            )).print()
}

class Solution399 {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val ufs = TypedUFS<String>(2 * equations.size)
        for (i in equations.indices) {
            ufs.union(equations[i][0], equations[i][1], values[i])
        }
        val ans = arrayListOf<Double>()
        queries.forEach {
//            ans.add(ufs.isConnected(it[0], it[1]))
        }
        return ans.toDoubleArray()
    }
}