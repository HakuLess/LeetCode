package leetcode.contest.cur.leetcode.c221

class Solution5637 {
    fun halvesAreAlike(s: String): Boolean {
        val arr = arrayOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        return s.substring(0, s.length / 2).count {
            it in arr
        } == s.substring(s.length / 2, s.length).count {
            it in arr
        }
    }
}