package leetcode.contest.cur.leetcode.c210

class Solution5536 {
    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        var ans = 0
        val map = HashMap<Int, ArrayList<Int>>()
        roads.forEach {
            map[it[0]] = map.getOrDefault(it[0], arrayListOf())
            map[it[0]]!!.add(it[1])
            map[it[1]] = map.getOrDefault(it[1], arrayListOf())
            map[it[1]]!!.add(it[0])
        }

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i != j) {
                    var res = map.getOrDefault(i, arrayListOf()).size + map.getOrDefault(j, arrayListOf()).size
                    if (j in map.getOrDefault(i, arrayListOf())) {
                        res--
                    }
                    ans = maxOf(ans, res)
                }
            }
        }
        return ans
    }
}