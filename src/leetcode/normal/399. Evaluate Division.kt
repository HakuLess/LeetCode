package leetcode.normal

import leetcode.contest.utils.TypedUFS

// todo not finished 带权并查集
class Solution399 {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val ufs = TypedUFS<String>(100)
        equations.forEach {
            ufs.union(it[0], it[1])
        }
        val ans = arrayListOf<Double>()
        queries.forEach {
            if (ufs.typedFind(it[0]) != ufs.typedFind(it[1])) {
                ans.add(-1.0)
            } else {

            }
        }
        return ans.toDoubleArray()
    }
}

