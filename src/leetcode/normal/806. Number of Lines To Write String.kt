package leetcode.normal

class Solution806 {
    fun numberOfLines(widths: IntArray, s: String): IntArray {
        var a = 1
        var b = 0
        s.forEach {
            if (b + widths[it - 'a'] > 100) {
                b = widths[it - 'a']
                a++
            } else {
                b += widths[it - 'a']
            }
        }
        return intArrayOf(a, b)
    }
}