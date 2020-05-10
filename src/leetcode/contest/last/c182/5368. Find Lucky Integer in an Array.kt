package leetcode.contest.last.c182

class Solution5368 {
    fun findLucky(arr: IntArray): Int {
        var ans = -1
        val map = HashMap<Int, Int>()
        arr.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        map.forEach { i, i2 ->
            if (i == i2) {
                ans = maxOf(ans, i)
            }
        }
        return ans
    }
}