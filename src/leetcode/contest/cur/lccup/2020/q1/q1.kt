package leetcode.contest.cur.lccup.`2020`.q1

class Solutionq1 {
    fun minCount(coins: IntArray): Int {
        var ans = 0
        coins.forEach {
            ans += if (it % 2 == 0) 0 else 1
            ans += it / 2
        }
        return ans
    }
}