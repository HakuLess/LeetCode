package leetcode.contest.last.b05

class Solution5034 {
    fun largestUniqueNumber(A: IntArray): Int {
        return A.filter { t ->
            A.count {
                it == t
            } == 1
        }.maxOrNull() ?: -1
    }
}