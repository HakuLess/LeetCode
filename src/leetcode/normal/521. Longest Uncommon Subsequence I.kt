package leetcode.normal

class Solution521 {
    fun findLUSlength(a: String, b: String): Int {
        return when (a) {
            b -> -1
            else -> maxOf(a.length, b.length)
        }
    }
}