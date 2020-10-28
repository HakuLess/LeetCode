package leetcode.contest.cur.leetcode.c212

class Solution1629 {
    fun slowestKey(releaseTimes: IntArray, keysPressed: String): Char {
        val a = ArrayList(releaseTimes.toList())
        a.add(0, 0)
        val b = keysPressed
        var res = ' '
        var cur = 0
        for (i in b.indices) {
            if (a[i + 1] - a[i] >= cur) {
                res = b[i]
                cur = a[i + 1] - a[i]
            }
        }
        return res
    }
}