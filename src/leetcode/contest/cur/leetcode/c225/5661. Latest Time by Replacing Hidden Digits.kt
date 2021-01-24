package leetcode.contest.cur.leetcode.c225

class Solution5661 {
    fun maximumTime(time: String): String {
        var (a, b) = time.split(":")
        if (a[0] == '?') {
            a = if (a[1] != '?' && a[1] - '0' > 3)
                "1" + a[1]
            else
                "2" + a[1]
        }
        if (a[1] == '?')
            a = a[0] + "9"
        if (b[0] == '?')
            b = "5" + b[1]
        if (b[1] == '?')
            b = b[0] + "9"
        a = minOf(23.toString(), a)
        b = minOf(59.toString(), b)
        return "$a:$b"
    }
}