package leetcode.contest.last.c151

class Solution1170 {
    fun numSmallerByFrequency(queries: Array<String>, words: Array<String>): IntArray {
        val a = IntArray(queries.size)
        val b = IntArray(words.size)
        for (i in a.indices) {
            a[i] = queries[i].count { it == queries[i].min() }
        }
        for (i in b.indices) {
            b[i] = words[i].count { it == words[i].min() }
        }
        val ans = arrayListOf<Int>()
        a.forEach { t ->
            ans.add(b.count { it > t })
        }
        return ans.toIntArray()
    }
}