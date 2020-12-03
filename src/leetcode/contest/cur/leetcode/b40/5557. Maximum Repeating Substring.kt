package leetcode.contest.cur.leetcode.b40

class Solution5557 {
    fun maxRepeating(sequence: String, word: String): Int {
        var cur = word
        var ans = 0
        while (sequence.contains(cur)) {
            cur += word
            ans++
        }
        return ans
    }
}