package leetcode.contest.cur.codeforces.kh5

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val array = readLine()!!.toString()
        var ans = array.count { it == 'w' }
        if (ans == 0) {
            println(array.length / 2)
            continue
        }
        array.split("w").forEach {
            ans += it.length / 2
        }
        println(ans)
    }
}