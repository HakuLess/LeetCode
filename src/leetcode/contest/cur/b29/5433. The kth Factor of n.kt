package leetcode.contest.cur.b29

class Solution5422 {
    fun kthFactor(n: Int, k: Int): Int {
        var ans = 0
        for (i in 1..n) {
            if (n % i == 0)
                ans++
            if (k == n) {
                return ans
            }
        }
        return -1
    }
}