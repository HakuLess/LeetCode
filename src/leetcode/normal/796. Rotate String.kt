package leetcode.normal

class Solution796 {
    fun rotateString(s: String, goal: String): Boolean {
        if (s.length != goal.length) {
            return false
        }
        return goal in "$s$s"
    }
}