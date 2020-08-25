package leetcode.contest.cur.leetcode.c198

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5466()
//    s.maxNumOfSubstrings("adefaddaccc").forEach {
//        it.print()
//    }

//    s.maxNumOfSubstrings("abab").forEach {
//        it.print()
//    }

    s.maxNumOfSubstrings("cabcccbaa").forEach {
        it.print()
    }
}

class Solution5466 {
    fun maxNumOfSubstrings(s: String): List<String> {
        val first = IntArray(26) { -1 }
        val last = IntArray(26) { -1 }
        s.forEachIndexed { index, c ->
            if (first[c - 'a'] == -1) {
                first[c - 'a'] = index
            }
            last[c - 'a'] = index
        }
        val l = ArrayList<Triple<Int, Int, Char>>()
        for (i in first.indices) {
            if (first[i] != -1)
                l.add(Triple(first[i], last[i], s[first[i]]))
        }
        val ans = ArrayList<String>()
        val seen = HashSet<Triple<Int, Int, Char>>()
        l.filter { it.second != -1 }.sortedBy { it.first }.map {
            var start = it.first
            var end = it.second
            var changed = false
            do {
                changed = false
                for (i in start..end) {
                    val t = l.first { it.third == s[i] }
                    if (t.first < start) {
                        start = minOf(start, t.first)
                        changed = true
                    }
                    if (t.second > end) {
                        end = maxOf(end, t.second)
                        changed = true
                    }
                }
            } while (changed)
            println("$start $end ${s[start]}")
            Triple(start, end, s[start])
        }.sortedBy { it.second - it.first }.forEach { pair ->
            if (seen.any { it.first >= pair.first && it.second <= pair.second }) {

            } else {
                ans.add(s.substring(pair.first, pair.second + 1))
                seen.add(pair)
            }
        }

        return ans
    }
}