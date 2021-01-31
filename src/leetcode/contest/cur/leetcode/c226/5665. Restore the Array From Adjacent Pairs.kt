package leetcode.contest.cur.leetcode.c226

class Solution5665 {
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        val map = HashMap<Int, ArrayList<Int>>()
        adjacentPairs.forEach {
            val (x, y) = it
            map.getOrPut(x, { arrayListOf() }).add(y)
            map.getOrPut(y, { arrayListOf() }).add(x)
        }
        val seen = HashSet<Int>()
        val ans = arrayListOf<Int>()
        fun dfs(i: Int) {
            ans.add(i)
            seen.add(i)
            for (v in map[i]!!) {
                if (v !in seen) {
                    dfs(v)
                }
            }
        }
        dfs(map.filter { it.value.size == 1 }.keys.first())
        return ans.toIntArray()
    }
}