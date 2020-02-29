package leetcode.contest.last.c175

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5333()
    s.minSteps("xxyyzz", "xxyyzz").print()
    s.minSteps("leetcode", "practice").print()
}

class Solution5333 {
    fun minSteps(s: String, t: String): Int {
        val tar = HashMap<Char, Int>()
        s.forEach {
            tar[it] = tar.getOrDefault(it, 0) + 1
        }
        val cur = HashMap<Char, Int>()
        t.forEach {
            cur[it] = cur.getOrDefault(it, 0) + 1
        }

        var ans = 0
        cur.forEach { (c, i) ->
            println("$c, $i, ${tar.getOrDefault(c, 0)}")
            if (i > tar.getOrDefault(c, 0)) {
                ans += i - tar.getOrDefault(c, 0)
            }
        }
        return ans
    }
}