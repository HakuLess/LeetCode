package leetcode.normal

class Solution434 {
    fun countSegments(s: String): Int {
        return s.split(' ').filter { it.isNotBlank() }.size
    }
}