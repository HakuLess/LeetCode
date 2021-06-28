package leetcode.contest.last.c172

class Solution5315 {
    fun maximum69Number (num: Int): Int {
        val s = StringBuilder(num.toString())
        s.indexOf('6').let {
            if (it != -1) s[it] = '9'
        }
        return s.toString().toInt()
    }
}