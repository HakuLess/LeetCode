package leetcode.normal

class Solution541 {
    fun reverseStr(s: String, k: Int): String {
        val chars = s.toCharArray()
        var start = 0
        while (start < chars.size) {
            var i = start
            var j = minOf(start + k - 1, chars.lastIndex)
            while (i < j) {
                val tmp = chars[i]
                chars[i++] = chars[j]
                chars[j--] = tmp
            }
            start += 2 * k
        }
        return String(chars)
    }
}