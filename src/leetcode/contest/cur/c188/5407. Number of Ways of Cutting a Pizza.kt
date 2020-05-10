package leetcode.contest.cur.c188

import leetcode.contest.utils.print

fun main() {
    val s = Solution5407()
//    s.ways(arrayOf("A..", "AAA", "..."), 3).print()
//    s.ways(arrayOf("A..", "AA.", "..."), 3).print()
//    s.ways(arrayOf("A..", "A..", "..."), 1).print()

    s.ways(arrayOf("AAAA.", "A..A.", "AA.AA"), 5).print()
}

class Solution5407 {

    val mod = 1000000007
    val seen = HashMap<Triple<Int, Int, Int>, Int>()
    fun ways(pizza: Array<String>, k: Int): Int {
        val ans = helper(pizza, Pair(0, 0), 0, k)
        return ans
    }

    private fun helper(pizza: Array<String>, cur: Pair<Int, Int>, cut: Int, k: Int): Int {
        val key = Triple(cur.first, cur.second, cut)
        println(key)
        if (key in seen) {
            return seen[key]!!
        }
        if (hasApple(pizza, cur) && cut == k - 1) {
            return 1
        }
        if (cut == k) {
            return 0
        }
        val pos = getlt(pizza, cur)
        println(pos)
        var ans = 0
        for (i in pos.second + 1..pizza.lastIndex) {
            ans = (ans + helper(pizza, Pair(cur.first, i), cut + 1, k)) % mod
        }
        for (j in pos.first + 1..pizza[0].lastIndex) {
            ans = (ans + helper(pizza, Pair(j, cur.second), cut + 1, k)) % mod
        }
//        println("$cur , $cut, $ans")
        seen[key] = ans
        return ans
    }

    private fun hasApple(pizza: Array<String>, cur: Pair<Int, Int>): Boolean {
        for (i in cur.second..pizza.lastIndex) {
            for (j in cur.first..pizza[0].lastIndex) {
                if (pizza[i][j] == 'A') {
                    return true
                }
            }
        }
        return false
    }

    private fun getlt(pizza: Array<String>, cur: Pair<Int, Int>): Pair<Int, Int> {
        var left = Int.MAX_VALUE / 2
        var top = Int.MAX_VALUE / 2
        for (i in cur.second..pizza.lastIndex) {
            for (j in cur.first..pizza[0].lastIndex) {
                if (pizza[i][j] == 'A') {
                    left = minOf(left, j)
                    top = minOf(top, i)
                }
            }
        }
        return Pair(left, top)
    }
}