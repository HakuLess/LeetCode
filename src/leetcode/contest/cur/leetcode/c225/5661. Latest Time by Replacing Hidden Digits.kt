package leetcode.contest.cur.leetcode.c225

class Solution5661 {
    fun maximumTime(time: String): String {
        val cur = CharArray(5) { ':' }
        val match = time.toCharArray()
        for (i in 23 downTo 0) {
            for (j in 59 downTo 0) {
                cur[0] = '0' + (i / 10)
                cur[1] = '0' + (i % 10)
                cur[3] = '0' + (j / 10)
                cur[4] = '0' + (j % 10)
                if (intArrayOf(0, 1, 3, 4).all { match[it] == '?' || match[it] == cur[it] }) {
                    return cur.joinToString("")
                }
            }
        }
        return ""
    }

//    fun maximumTime(time: String): String {
//        var (a, b) = time.split(":")
//        if (a[0] == '?') {
//            a = if (a[1] != '?' && a[1] - '0' > 3)
//                "1" + a[1]
//            else
//                "2" + a[1]
//        }
//        if (a[1] == '?')
//            a = a[0] + "9"
//        if (b[0] == '?')
//            b = "5" + b[1]
//        if (b[1] == '?')
//            b = b[0] + "9"
//        a = minOf(23.toString(), a)
//        b = minOf(59.toString(), b)
//        return "$a:$b"
//    }
}