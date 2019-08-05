package leetcode.contest.cur.c148

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution1147()
    s.longestDecomposition("antaprezatepzapreanta").print()
    s.longestDecomposition("elvtoelvto").print()
}

class Solution1147 {
    fun longestDecomposition(text: String): Int {
        var t = 0
        var ans = 0
        var str = text
        while (t != -1 && str.isNotEmpty()) {
            t = getIndex(str)
//            println("$t ${str.length - t - 1}")
            str = str.substring(IntRange(t + 1, str.length - t - 2))
//            str.print()
            ans += if (t == -1) {
                1
            } else {
                2
            }
        }
        return ans
    }

    private fun getIndex(text: String): Int {
        var first = 0
        var last = text.lastIndex
        var a = ""
        var b = ""
        while (first < last) {
            a += text[first]
            b = text[last] + b
            if (a == b) {
                return first
            }
            first++
            last--
        }

        return -1
    }
}