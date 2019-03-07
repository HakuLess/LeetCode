package leetcode

class Solution58 {
    fun lengthOfLastWord(s: String): Int {
        return s.trim().split(' ').last().length
    }
}