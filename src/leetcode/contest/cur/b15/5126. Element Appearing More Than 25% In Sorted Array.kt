package leetcode.contest.cur.b15

class Solution5126 {
    fun findSpecialInteger(arr: IntArray): Int {
        val t = arr.size / 4
        val map = HashMap<Int, Int>()
        arr.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
            if (map[it]!! >= t) {
                return it
            }
        }
        return -1
    }
}