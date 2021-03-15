package leetcode.contest.last.b43

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution1717()
    s.maximumGain("cdbcbbaaabab", 4, 5).print()
}

class Solution1717 {
    fun maximumGain(s: String, x: Int, y: Int): Int {
        var ans = 0
        fun dfs(s: String, a: Char, b: Char, v: Int): String {
            val st = Stack<Char>()
            s.forEach {
                if (it == a && st.isNotEmpty() && st.peek() == b) {
                    st.pop()
                    ans += v
                } else {
                    st.add(it)
                }
            }
            return st.joinToString("")
        }
        val (a, b) = if (x >= y) Pair('a', 'b') else Pair('b', 'a')
        val (big, small) = if (x >= y) Pair(x, y) else Pair(y, x)
        val next = dfs(s, b, a, big)
        dfs(next, a, b, small)
        return ans
    }
}