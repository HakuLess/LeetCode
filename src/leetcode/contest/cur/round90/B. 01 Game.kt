package leetcode.contest.cur.round90

import java.util.*

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val s = readLine()!!.toString()
        val st = Stack<Char>()
        var count = 0
        s.forEach {
            if (st.isEmpty()) {
                st.push(it)
            } else if (st.peek() != it) {
                st.pop()
                count++
            } else {
                st.push(it)
            }
        }
        if (count % 2 == 0) {
            println("NET")
        } else {
            println("DA")
        }
    }
}