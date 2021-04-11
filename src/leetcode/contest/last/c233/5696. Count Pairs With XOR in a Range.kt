package leetcode.contest.last.c233

import leetcode.contest.utils.Trie
import leetcode.contest.utils.insertInt
import leetcode.contest.utils.print
import leetcode.contest.utils.smaller

fun main(args: Array<String>) {
    val s = Solution5696()
    s.countPairs(intArrayOf(1, 4, 2, 7), 2, 6).print()
}

class Solution5696 {
    fun countPairs(nums: IntArray, low: Int, high: Int): Int {
        val trie = Trie<Int>()
        var ans = 0
        nums.forEach {
            ans += trie.smaller(it, high + 1)
            ans -= trie.smaller(it, low)
            trie.insertInt(it)
        }
        return ans
    }
}