package leetcode.normal

import leetcode.TypedUFS
import leetcode.print

fun main(args: Array<String>) {
    val a = Solution128()
    a.longestConsecutive(
            intArrayOf(100, 4, 200, 1, 3, 2)
    ).print()
}

class Solution128 {
    fun longestConsecutive(nums: IntArray): Int {
        val disNums = nums.distinct()
        if (disNums.size <= 1) {
            return disNums.size
        }
        val map = HashMap<Int, Int>()
        val ufs = TypedUFS<Int>(disNums.size * 3)
        disNums.forEach {
            ufs.union(it, it - 1)
        }

        disNums.forEach {
            val key = ufs.typedFind(it)
            map[key] = map.getOrDefault(key, 0) + 1
        }

        var ans = 0
        map.forEach { (_, u) ->
            ans = maxOf(ans, u)
        }
        return ans
    }
}