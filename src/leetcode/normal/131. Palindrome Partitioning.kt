package leetcode.normal

import leetcode.contest.utils.isPalindrome
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution131()
    s.partition("aab").forEach {
        it.joinToString().print()
    }
}

class Solution131 {
    fun partition(s: String): List<List<String>> {
        val ans = ArrayList<List<String>>()
        fun dfs(cur: String, pre: ArrayList<String>) {
            if (cur.isPalindrome()) {
                val clone = pre.clone() as ArrayList<String>
                clone.add(cur)
                ans.add(clone)
            }
            for (i in 1 until cur.length) {
                if (cur.substring(0, i).isPalindrome()) {
                    val clone = pre.clone() as ArrayList<String>
                    clone.add(cur.substring(0, i))
                    dfs(cur.substring(i, cur.length), clone)
                }
            }
        }
        dfs(s, arrayListOf())
        return ans
    }
}