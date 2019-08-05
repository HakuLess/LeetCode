package leetcode.contest.last.c143

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution1103()
    s.distributeCandies(10, 3).print()
}

class Solution1103 {
    fun distributeCandies(candies: Int, num_people: Int): IntArray {
        val ans = IntArray(num_people)
        var left = candies
        var index = 0
        var step = 1
        while (left != 0) {
            ans[index % num_people] += minOf(step, left)
            left -= minOf(step, left)
            step++
            index++
        }
        return ans
    }
}