package leetcode.contest.cur.c187

class Solution5400 {
    fun destCity(paths: List<List<String>>): String {
        val map = HashMap<String, String>()
        paths.forEach {
            map[it[0]] = it[1]
        }
        map.values.forEach {
            if (!map.containsKey(it)) {
                return it
            }
        }
        return ""
    }
}