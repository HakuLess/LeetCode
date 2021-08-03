package leetcode.normal

class Solution693 {
    fun hasAlternatingBits(n: Int): Boolean {
        var pre = ' '
        Integer.toBinaryString(n).forEach {
            pre = when {
                pre == ' ' -> it
                it == pre -> return false
                else -> it
            }
        }
        return true
    }
}