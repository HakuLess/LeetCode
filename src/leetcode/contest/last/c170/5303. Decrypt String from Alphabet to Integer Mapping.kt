package leetcode.contest.last.c170

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5303()
    s.freqAlphabets("10#11#12").print()
    s.freqAlphabets("1326#").print()
    s.freqAlphabets("25#").print()
    s.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#").print()
}

class Solution5303 {
    fun freqAlphabets(s: String): String {
        var ans = ""
        var temp = ""
        var t = false
        s.reversed().forEach {
            if (it == '#') {
                t = true
            } else if (t) {
                temp = it + temp
                if (temp.length == 2) {
                    ans += ('a' + temp.toInt() - 1).toChar()
                    temp = ""
                    t = false
                }
            } else {
                ans += ('a' + it.toInt() - '0' - 1).toChar()
            }
        }
        return ans.reversed()
    }
}