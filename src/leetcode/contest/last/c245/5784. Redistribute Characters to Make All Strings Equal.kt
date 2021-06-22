package leetcode.contest.last.c245

class Solution5784 {
    fun makeEqual(words: Array<String>): Boolean {
        val n = words.size
        val cur = IntArray(26)
        words.forEach {
            it.forEach {
                cur[it - 'a']++
            }
        }
        return cur.all { it % n == 0 }
    }
}