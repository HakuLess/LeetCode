package leetcode.contest.last.c168

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5293()
    s.maxFreq("aababcaab", 2, 3, 4).print()
    s.maxFreq("abcde", 2, 3, 3).print()
}

class Solution5293 {
    fun maxFreq(s: String, maxLetters: Int, minSize: Int, maxSize: Int): Int {
        val map = HashMap<String, Int>()
        for (i in s.indices) {
            for (j in minSize..maxSize) {
                if (i + j > s.lastIndex + 1) {
                    break
                }
                val it = s.substring(i, i + j)
                it.print()
                if (check(it) <= maxLetters) {
                    map[it] = map.getOrDefault(it, 0) + 1
                } else {
                    break
                }
            }
        }
        if (map.isEmpty()) {
            return 0
        }
        return map.values.max()!!
    }

    private fun check(s: String): Int {
        val a = IntArray(26) { 0 }
        s.forEach {
            a[it - 'a'] = 1
        }
        return a.sum()
    }
}