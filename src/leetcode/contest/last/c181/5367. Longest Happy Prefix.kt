package leetcode.contest.last.c181

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5367()
    s.longestPrefix("level").print()
    s.longestPrefix("aabcdaabc").print()
    s.longestPrefix("ababab").print()
    s.longestPrefix("blablabla").print()
    s.longestPrefix("acccbaaacccbaac").print()
}

class Solution5367 {
//    fun longestPrefix(s: String): String {
//        var ans = ""
//        var start = ""
//        var end = ""
//        for (i in 0 until s.lastIndex) {
//            start += s[i]
//            end = s[s.lastIndex - i] + end
//            if (start == end) {
//                ans = start
//            }
//        }
//        return ans
//    }

    fun longestPrefix(s: String): String {
        val mod = 1000000007
        val a = 31
        val n = s.length
        var sHash: Long = 0
        var rHash: Long = 0
        var p: Long = 1
        var res = 0
        for (i in 0 until n - 1) {
            val c = s[i] - 'a'
            val rc = s[n - 1 - i] - 'a'
            sHash = (sHash * a % mod + c) % mod
            rHash = (rHash + rc * p % mod) % mod
            p = p * a % mod
            if (sHash == rHash) {
                res = i + 1
            }
        }
        return s.substring(0, res)
    }

//    fun longestPrefix(s: String): String {
//        if (s.count { it == s.last() } == 1) {
//            return ""
//        }
//        if (s.length <= 1) return ""
//        val pre = s.substring(0, s.length - 1).toCharArray()
//        val suf = s.substring(1, s.length).toCharArray()
//        val len = pre.size
//        var length = 0
//        for (i in pre.indices) {
//            var j = 0
//            var k = i
//            while (j < pre.size && k < suf.size) {
//                if (pre[j] == suf[k]) length++ else {
//                    length = 0
//                    break
//                }
//                j++
//                k++
//            }
//            if (length != 0) break
//        }
//        return s.substring(IntRange(0, length - 1))
//    }
}