package leetcode.contest.cur

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution482()
    s.licenseKeyFormatting("5F3Z-2e-9-w", 4).print()
    s.licenseKeyFormatting("2-4A0r7-4k", 4).print()
    s.licenseKeyFormatting("2-5g-3-J", 2).print()
}

class Solution482 {
    fun licenseKeyFormatting(S: String, K: Int): String {
        val st = Stack<Char>()
        var ans = ""
        S.toUpperCase().forEach {
            if (it != '-') {
                st.add(it)
            }
        }
        var cur = "-"
        while (st.isNotEmpty()) {
            cur = st.pop() + cur
            if (cur.length == K + 1) {
                ans = cur + ans
                cur = "-"
            }
        }
        if (cur.isNotBlank()) {
            ans = cur + ans
        }
        return ans.trim('-')
    }
}