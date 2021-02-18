package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution467()
//    s.findSubstringInWraproundString("zaba").print()
    s.findSubstringInWraproundString("cac").print()
//    s.findSubstringInWraproundString("zabcd").print()
//    s.findSubstringInWraproundString("a").print()
}

class Solution467 {
    fun findSubstringInWraproundString(p: String): Int {
        if (p.isEmpty()) {
            return 0
        }
        var sum = 1
        val c = IntArray(26) { 0 }
        c[p[0] - 'a'] = 1
        for (i in 1 until p.length) {
            if ((p[i] - p[i - 1] - 1) % 26 == 0) {
                sum++
            } else {
                sum = 1
            }
            c[p[i] - 'a'] = maxOf(c[p[i] - 'a'], sum)
        }
        return c.sum()
    }
}