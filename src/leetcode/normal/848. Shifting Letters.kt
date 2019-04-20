package leetcode.normal

import leetcode.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution848()
    s.shiftingLetters("abc", intArrayOf(3, 5, 9)).print()
}

class Solution848 {
    fun shiftingLetters(S: String, shifts: IntArray): String {
        val ans = StringBuilder()
        var offset = 0
        for (i in S.lastIndex downTo 0) {
            val item = S[i]
            offset += shifts[i]
            offset %= 26
            println(item + offset)
            if (item + offset in 'a'..'z') {
                ans.append(item + offset)
            } else {
                ans.append(item + offset - 26)
            }
        }
        return ans.toString().reversed()
    }
}