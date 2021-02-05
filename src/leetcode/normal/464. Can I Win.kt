package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution464()
    s.canIWin(5, 50).print()
    s.canIWin(4, 6).print()
    s.canIWin(10, 11).print()
    s.canIWin(20, 300).print()
}

class Solution464 {
    fun canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean {
        if (desiredTotal <= maxChoosableInteger) return true
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false
        val seen = HashMap<String, Boolean>()
        fun dfs(arr: BooleanArray, sum: Int): Boolean {
            val key = arr.joinToString(",")
            if (key in seen.keys) return seen[key]!!
            if (sum >= desiredTotal) {
                return false
            }
            for (i in 1..maxChoosableInteger) {
                if (!arr[i]) {
                    arr[i] = true
                    val ans = dfs(arr, sum + i)
                    arr[i] = false
                    if (!ans) return true.also {
                        seen[key] = it
                    }
                }
            }
            return false
        }
        return dfs(BooleanArray(maxChoosableInteger + 1), 0)
    }
}