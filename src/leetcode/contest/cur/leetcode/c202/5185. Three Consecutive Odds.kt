package leetcode.contest.cur.leetcode.c202

class Solution5185 {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        var count = 0
        arr.forEach {
            if (it % 2 == 1) {
                count++
                if (count >= 3) return true
            } else {
                count = 0
            }
        }
        return false
    }
}