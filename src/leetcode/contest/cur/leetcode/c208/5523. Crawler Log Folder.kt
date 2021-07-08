package leetcode.contest.cur.leetcode.c208

class Solution5523 {
    fun minOperations(logs: Array<String>): Int {
        var ans = 0
        for (log in logs) {
            when {
                log == "../" -> ans = maxOf(0, ans - 1)
                log != "./" -> ans++
            }
        }
        return ans
    }
}