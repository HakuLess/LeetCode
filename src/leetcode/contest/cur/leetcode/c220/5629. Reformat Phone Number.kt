package leetcode.contest.cur.leetcode.c220

class Solution5629 {
    fun reformatNumber(number: String): String {
        fun dfs(str: String): String {
            return when (str.length) {
                4 -> "${str.substring(0, 2)}-${str.substring(2, 4)}"
                3 -> str
                2 -> str
                else -> "${str.substring(0, 3)}-${dfs(str.substring(3, str.length))}"
            }
        }
        return dfs(number.filter { it != ' ' && it != '-' })
    }
}