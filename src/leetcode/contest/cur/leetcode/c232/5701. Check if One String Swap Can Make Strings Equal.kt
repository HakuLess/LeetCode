package leetcode.contest.cur.leetcode.c232

class Solution5701 {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        val l = arrayListOf<Int>()
        for (i in s1.indices) {
            if (s1[i] != s2[i]) {
                l.add(i)
            }
        }
        if (l.size == 0) return true
        if (l.size == 2 && s1[l[0]] == s2[l[1]] && s1[l[1]] == s2[l[0]]) {
            return true
        }
        return false
    }
}