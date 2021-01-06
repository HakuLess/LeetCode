package leetcode.normal

import leetcode.contest.utils.TypedUFS

class Solution721 {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val ufs = TypedUFS<String>(10000)
        val map = HashMap<String, String>()
        accounts.forEach {
            for (i in 1 until it.size) {
                map[it[i]] = it[0]
                ufs.union(it[i], it[1])
            }
        }

        val ans = HashMap<Int, HashSet<String>>()
        accounts.forEach {
            for (i in 1 until it.size) {
                val p = ufs.typedFind(it[i])
                if (p !in ans.keys) {
                    ans[p] = hashSetOf()
                    ans[p]!!.add(it[0])
                    ans[p]!!.add(it[i])
                } else {
                    ans[p]!!.add(it[i])
                }
            }
        }
        return ans.values.map { it.toList().sorted() }
    }
}