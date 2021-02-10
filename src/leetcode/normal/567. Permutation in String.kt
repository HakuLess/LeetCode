package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution567()
    s.checkInclusion("adc", "dcda").print()

}

class Solution567 {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length)
            return false
        val target = IntArray(26)
        val cur = IntArray(26)
        s1.forEach {
            target[it - 'a']++
        }
        for (i in s2.indices) {
            if (i >= s1.length)
                cur[s2[i - s1.length] - 'a']--
            cur[s2[i] - 'a']++
            if (cur.contentEquals(target))
                return true
        }
        return false
    }
}