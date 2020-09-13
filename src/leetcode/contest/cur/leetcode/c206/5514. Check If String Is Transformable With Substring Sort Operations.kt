package leetcode.contest.cur.leetcode.c206

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5514()
    s.isTransformable("84532", "34852").print()
    s.isTransformable("1331", "3113").print()
    s.isTransformable("2911", "1192").print()
}

// Error
class Solution5514 {
    fun isTransformable(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val cnt = IntArray(10)
        for (i in s.indices) {
            cnt[s[i] - '0']++
            cnt[t[i] - '0']--
        }
        if (cnt.any { it != 0 }) return false

        val st = Array<Stack<Int>>(10) { Stack() }
        for (i in s.indices) {
            st[s[i] - '0'].add(i)
        }
        for (c in t.reversed()) {
            val id = st[c - '0'].pop()
            for (i in c - '0' + 1..9) {
                if (st[i].isNotEmpty() && st[i].peek() > id) {
                    return false
                }
            }
        }
        return true
    }

    // Error
//    fun isTransformable(s: String, t: String): Boolean {
//        return helper(s, t, '9')
//    }
//
//    private fun helper(s: String, t: String, c: Char): Boolean {
//        if (c !in '0'..'9') return true
//        var i = 0
//        var j = 0
//        while (i < s.length && j < t.length) {
//            while (i < s.length && s[i] != c) {
//                i++
//            }
//            while (j < t.length && t[j] != c) {
//                j++
//            }
//            if (i == s.length && j == t.length) {
//                return helper(s.replace(c.toString(), ""), t.replace(c.toString(), ""), c - 1)
//            }
//            if (i == s.length || j == t.length) return false
//            if (i > j) {
//                return false
//            }
//            i++
//            j++
//        }
//        return helper(s.replace(c.toString(), ""), t.replace(c.toString(), ""), c - 1)
//    }
}