package leetcode.normal

class Solution989 {
    fun addToArrayForm(A: IntArray, K: Int): List<Int> {
        return (A.joinToString("").toBigInteger() + K.toBigInteger()).toString(10).toList().map {
            it - '0'
        }
    }
}