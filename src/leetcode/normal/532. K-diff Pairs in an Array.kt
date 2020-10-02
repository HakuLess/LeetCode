package leetcode.normal

/**
 * Created by HaKu on 2018/6/2.
 */
class Solution532 {
    fun findPairs(nums: IntArray, k: Int): Int {
        if (k < 0) {
            return 0
        }
        var count = 0
        val map = mutableMapOf<Int, Int>()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        map.keys.forEach {
            if (k == 0) {
                if (map[it]!! > 1) {
                    count++
                }
            } else {
                if (map.containsKey(it + k)) {
                    count++
                }
            }
        }
        return count
    }
}