package leetcode.contest.last.c182

class Solution5368 {
    fun findLucky(arr: IntArray): Int {
        return arr.filter { c -> arr.count { it == c } == c }.maxOrNull() ?: -1
    }
}