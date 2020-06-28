package leetcode.contest.cur.c195

class Solution5448 {
    fun isPathCrossing(path: String): Boolean {
        val set = HashSet<Pair<Int, Int>>()
        var cur = Pair(0, 0)
        set.add(cur)
        path.forEach {
            when(it) {
                'N' -> cur = Pair(cur.first, cur.second + 1)
                'S' -> cur = Pair(cur.first, cur.second - 1)
                'E' -> cur = Pair(cur.first + 1, cur.second)
                'W' -> cur = Pair(cur.first - 1, cur.second)
            }
            if (set.contains(cur)) {
                return true
            }
            set.add(cur)
        }
        return false
    }
}