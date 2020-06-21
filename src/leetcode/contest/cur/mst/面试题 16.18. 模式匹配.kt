package leetcode.contest.cur.mst

import leetcode.contest.utils.print
import kotlin.Exception

fun main(args: Array<String>) {
    val s = Solution1618()
//    s.patternMatching("abba", "dogcatcatdog").print()
//    s.patternMatching("bbbbbbbbabbbbbbbbbbbabbbbbbba", "zezezezezezezezezkxzezezezezezezezezezezezkxzezezezezezezezkx").print()
//    s.patternMatching("bbba", "xxxxxxy").print()
//    s.patternMatching("bbba", "xxxxxx").print()
//    s.patternMatching("a", "zqvamqvuuvvazv").print()
//    s.patternMatching("bbb", "xxxxxx").print()
//    s.patternMatching("bbbaa", "xxxxxxy").print()
//    s.patternMatching("abbbb", "hggmuhqsudtcbyhcuumscubdbtumscubdbumscubdb").print()
    s.patternMatching("baabab", "eimmieimmieeimmiee").print()
}

class Solution1618 {
    fun patternMatching(pattern: String, value: String): Boolean {
        return if (pattern.startsWith('a')) {
            getAns(pattern, value)
        } else {
            getAns(pattern.map {
                when (it) {
                    'a' -> 'b'
                    else -> 'a'
                }
            }.joinToString(""), value)
        }
    }

    private fun getAns(pattern: String, value: String): Boolean {
        fun check(a: String, b: String): Boolean {
            println("ans $a, $b")
            val result = pattern.map {
                when (it) {
                    'a' -> a
                    else -> b
                }
            }.joinToString("")
            return result == value
        }
        if (pattern.isEmpty()) {
            return value.isEmpty()
        }
        if (value.isEmpty()) {
            return pattern.all { it == pattern[0] }
        }
        if (pattern.all { it == 'a' }) {
            if (value.length % pattern.length != 0) return false
            return check(value.substring(0, value.length / pattern.length), "")
        }
        val aCount = pattern.count { it == 'a' }
        val bCount = pattern.count { it == 'b' }

        var aSize = 0
        var bSize = 0
        for (i in 0..value.length) {
            aSize = i
            bSize = value.length - aSize * aCount
            if (bSize % bCount != 0) {
                continue
            }
            bSize /= bCount
            val a = value.substring(0, aSize)
            var cur = aSize
            val pos = pattern.indexOfFirst { it == 'b' }
            val start = pos * aSize
            val b = try {
                value.substring(start, start + bSize)
            } catch (ex: Exception) {
                ""
            }
            if (check(a, b)) {
                return true
            }
        }
        return false
    }
}