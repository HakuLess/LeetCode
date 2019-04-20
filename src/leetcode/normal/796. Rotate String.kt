package leetcode.normal

class Solution796 {
    fun rotateString(A: String, B: String): Boolean {
        if (A.length != B.length) {
            return false
        }
        val sb = "$A$A"
        return sb.indexOf(B) >= 0
    }
}