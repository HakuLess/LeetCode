package leetcode.contest.cur.codeforces.ecr94

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (c in 0 until t) {
        val n = readLine()!!.toInt()
        val s = readLine().toString()
        var ans = ""
        for (i in s.indices step 2) {
            ans += s[i]
        }
        println(ans)
    }
}