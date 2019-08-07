package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution781()
    s.numRabbits(intArrayOf(10, 10, 10)).print()
}

class Solution781 {
    fun numRabbits(answers: IntArray): Int {
        var ans = 0

        val map = hashMapOf<Int, Int>()
        answers.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        map.forEach { t, u ->
            ans += u
            if (t != 0 && u % (t + 1) != 0) {
                ans += (t + 1) - u % (t + 1)
            }
        }
        return ans
    }
}