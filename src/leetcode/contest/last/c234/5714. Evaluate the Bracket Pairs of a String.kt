package leetcode.contest.last.c234

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val s = Solution5714()
    s.evaluate("(name)is(age)yearsold", listOf(listOf("name", "bob"), listOf("age", "two"))).print()
}

class Solution5714 {
    fun evaluate(s: String, knowledge: List<List<String>>): String {
        val map = HashMap<String, String>()
        knowledge.forEach {
            map[it[0]] = it[1]
        }
        val st = Stack<Char>()
        var ans = ""
        var meet = false
        for (i in s.indices) {
            if (s[i] == '(') {
                meet = true
                continue
            } else if (s[i] == ')') {
                meet = false
                ans += map.getOrDefault(st.joinToString(""), "?")
                st.clear()
                continue
            }
            if (meet) {
                st.add(s[i])
            } else {
                ans += s[i]
            }
        }
        return ans
    }
}