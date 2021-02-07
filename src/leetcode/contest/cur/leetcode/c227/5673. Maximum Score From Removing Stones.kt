package leetcode.contest.cur.leetcode.c227

class Solution5673 {
    fun maximumScore(a: Int, b: Int, c: Int): Int {
        val (a, b, c) = intArrayOf(a, b, c).sorted()
        if (a + b <= c)
            return a + b
        return (a + b + c) / 2
    }
}