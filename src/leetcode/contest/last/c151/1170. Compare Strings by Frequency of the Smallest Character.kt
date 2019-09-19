package leetcode.contest.last.c151

class Solution1170 {
    fun numSmallerByFrequency(queries: Array<String>, words: Array<String>): IntArray {
        val a = IntArray(queries.size)
        val b = IntArray(words.size)

        for (i in 0 until a.size) {
            a[i] = f(queries[i])
        }
        for (i in 0 until b.size) {
            b[i] = f(words[i])
        }
        val ans = arrayListOf<Int>()
        a.forEach { t ->
            ans.add(b.count { it > t })
        }
        return ans.toIntArray()
    }

    private fun f(s: String): Int {
        var c = 'z'
        s.forEach {
            c = minOf(it, c)
        }
        return s.count { it == c }
    }
}