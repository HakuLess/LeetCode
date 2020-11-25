package leetcode.contest.last.b21

import leetcode.contest.utils.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution5336()
    s.sortString("aaaabbbbcccc").print()
}

class Solution5336 {
    fun sortString(s: String): String {
        val arr = IntArray(28)
        s.forEach {
            arr[it - 'a' + 1]++
        }
        var cur = 0
        val ans = StringBuilder()
        var add = true
        while (!arr.all { it == 0 }) {
            if (arr[cur] != 0) {
                ans.append('a' + cur - 1)
                arr[cur]--
            }
            if (cur == 0) add = true
            if (cur == 27) add = false
            if (add) cur++
            else cur--
        }
        return ans.toString()
    }
}