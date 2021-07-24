package leetcode.contest.cur.leetcode.b57

class Solution5804 {
    fun areOccurrencesEqual(s: String): Boolean {
        val map = HashMap<Char, Int>()
        s.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        return map.values.toSet().size == 1
    }
}