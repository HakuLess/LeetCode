package leetcode.contest.last.c154

class Solution5189 {
    fun maxNumberOfBalloons(text: String): Int {
        var b = 0
        var a = 0
        var l = 0
        var o = 0
        var n = 0
        text.forEach {
            when (it) {
                'b' -> b++
                'a' -> a++
                'l' -> l++
                'o' -> o++
                'n' -> n++
            }
        }
        l /= 2
        o /= 2
        return intArrayOf(b, a, l, o, n).min()!!
    }
}