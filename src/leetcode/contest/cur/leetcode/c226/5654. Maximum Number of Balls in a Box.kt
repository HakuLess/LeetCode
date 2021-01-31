package leetcode.contest.cur.leetcode.c226

class Solution5654 {
    fun countBalls(lowLimit: Int, highLimit: Int): Int {
        val map = HashMap<Int, Int>()
        for (i in lowLimit..highLimit) {
            val k = i.toString().sumBy { it - '0' }
            map[k] = map.getOrDefault(k, 0) + 1
        }
        return map.values.max()!!
    }
}