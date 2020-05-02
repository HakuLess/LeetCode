package leetcode.contest.cur.b25

class Solution5386 {
    fun checkIfCanBreak(s1: String, s2: String): Boolean {
        val c1 = s1.toCharArray()
        val c2 = s2.toCharArray()
        c1.sort()
        c2.sort()

        return check(c1, c2) || check(c2, c1)
    }

    private fun check(c1: CharArray, c2: CharArray): Boolean {
        for (i in c1.indices) {
            if (c1[i] < c2[i])
                return false
        }
        return true
    }
}