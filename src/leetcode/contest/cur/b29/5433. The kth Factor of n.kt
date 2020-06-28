package leetcode.contest.cur.b29

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5422()
    s.kthFactor(12, 3).print()
}
class Solution5422 {
    fun kthFactor(n: Int, k: Int): Int {
        var ans = 0
        for (i in 1..n) {
            if (n % i == 0)
                ans++
            if (k == ans) {
                return i
            }
        }
        return -1
    }
}