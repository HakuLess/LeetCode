package leetcode.contest.cur.`2020`.q3

class Solution1 {
    fun calculate(s: String): Int {
        var x = 1
        var y = 0
        for (c in s) {
            if (c == 'A') {
                x = 2 * x + y
            } else {
                y = 2 * y + x
            }
        }
        return x + y
    }
}