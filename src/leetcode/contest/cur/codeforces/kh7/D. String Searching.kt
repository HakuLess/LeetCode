package leetcode.contest.cur.codeforces.kh7

import leetcode.contest.utils.lcs
import leetcode.contest.utils.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val set = HashSet<String>()
    repeat(n) {
        set.add(readLine()!!.toString())
    }
    val q = readLine()!!.toInt()
    repeat(q) {
        val query = readLine()!!.toString()
        var ans = 0
        val seen = hashSetOf<String>()
        for (i in 0..m) {
            val sb = StringBuilder(query)
            sb.replace(i, i + 1, "")
            if (sb.toString() in seen) continue
            ans += if (sb.toString() in set) 1 else 0
            seen.add(sb.toString())
        }
        println(ans)
    }
}