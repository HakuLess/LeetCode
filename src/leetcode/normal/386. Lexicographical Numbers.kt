package leetcode.normal

import java.util.*


class Solution386 {
    fun lexicalOrder(n: Int): List<Int> {
        val ans = ArrayList<Int>()
        fun dfs(n: Int, i: Int) {
            if (i > n) {
                return
            }
            ans.add(i)
            for (j in 0..9) {
                dfs(n, i * 10 + j)
            }
        }
        for (i in 1..9) {
            dfs(n, i)
        }
        return ans
    }
}