package leetcode.contest.cur.b23

class Solution5362 {
    fun canConstruct(s: String, k: Int): Boolean {
        val map = HashMap<Char, Int>()
        s.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        var n = 0
        map.forEach { c, i ->
            if (i % 2 != 0) {
                n++
            }
        }
        return n <= k && s.length >= k
    }
}