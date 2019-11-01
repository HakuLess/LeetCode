package leetcode.normal

import leetcode.contest.utils.print
import java.lang.StringBuilder
import java.util.*

fun main(args: Array<String>) {
    val s = Solution6()
//    s.convert("A", 1).print()
//    s.convert("PAYPALISHIRING", 4).print()
    s.convert("ABCD", 3).print()
}

class Solution6 {
    fun convert(s: String, numRows: Int): String {
        if (numRows < 2) return s

        val list = ArrayList<StringBuilder>()
        for (i: Int in 1..numRows) {
            list.add(StringBuilder())
        }

        var i = 0;
        var flag = -1;
        s.toCharArray().forEach {
            if (i == 0 || i == numRows - 1) {
                flag = -flag
            }

            list[i].append(it)
            i += flag
        }

        val ans = StringBuilder()
        list.forEach {
            ans.append(it)
        }
        return ans.toString()
    }
}