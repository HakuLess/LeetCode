package leetcode.contest.cur.leetcode.b41

class Solution1686 {
    fun stoneGameVI(aliceValues: IntArray, bobValues: IntArray): Int {
        val c = ArrayList<Pair<Int, Int>>()
        for (i in aliceValues.indices) {
            c.add(Pair(i, aliceValues[i] + bobValues[i]))
        }
        var a = 0
        var b = 0
        c.sortedByDescending { it.second }.forEachIndexed { index, i ->
            if (index % 2 == 0) {
                a += aliceValues[i.first]
            } else {
                b += bobValues[i.first]
            }
        }
        return if (a == b) 0 else if (a > b) 1 else -1
    }
}