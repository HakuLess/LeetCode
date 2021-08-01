package leetcode.contest.cur.leetcode.c252

class Solution5830 {
    fun isThree(n: Int): Boolean {
        var tmp = 0
        for (i in 1..n) {
            if (n % i == 0) {
                tmp++
                if (tmp > 3) return false
            }
        }
        return tmp == 3
    }
}