package leetcode.normal

class Solution168 {
    fun convertToTitle(n: Int): String {
        var t = n
        var ans = ""
        while (t > 0) {
            val c = (t - 1) % 26
            ans = ('A' + c) + ans
            t = (t - 1) / 26
        }
        return ans
    }
}