package leetcode.contest.last.c235

class Solution5723 {
    fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {
        val map = HashMap<Int, HashSet<Int>>()
        logs.forEach {
            map[it[0]] = map.getOrDefault(it[0], hashSetOf())
            map[it[0]]!!.add(it[1])
        }
        val ans = IntArray(k)
        map.forEach { (i, set) ->
            if (set.size in ans.indices) {
                ans[set.size - 1]++
            }
        }
        return ans
    }
}