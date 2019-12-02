package leetcode.contest.cur.b14

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5112()
    s.toHexspeak("257").print()
    s.toHexspeak("3").print()
    s.toHexspeak("619879596177").print()
}

class Solution5112 {
    fun toHexspeak(num: String): String {
        var str = num.toLong().toString(16).toUpperCase()
        str = str.replace('0', 'O')
        str = str.replace('1', 'I')
        if (str.all { it !in '0'..'9' })
            return str
        return "ERROR"
    }
}