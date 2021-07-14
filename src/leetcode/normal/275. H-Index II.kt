package leetcode.normal

class Solution275 {
    fun hIndex(citations: IntArray): Int {
        var left = 0
        var right = citations.size
        while (left + 1 < right) {
            val mid = (left + right).ushr(1)
            when {
                citations.count { it >= mid } >= mid -> left = mid
                else -> right = mid
            }
        }
        return if (citations.count { it >= right } >= right) {
            right
        } else {
            left
        }
    }
}