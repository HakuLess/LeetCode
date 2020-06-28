package leetcode.contest.cur.cf653

import java.util.*

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val n = readLine()!!.toInt()
        val s = readLine()!!.toString()
        val st = Stack<Char>()
        s.forEach {
            if (st.isEmpty()) st.push(it)
            else {
                if (it == ')' && st.peek() == '(') {
                    st.pop()
                } else {
                    st.push(it)
                }
            }
        }
        println(st.size / 2)
    }
}