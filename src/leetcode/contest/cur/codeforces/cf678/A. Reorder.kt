package leetcode.contest.cur.codeforces.cf678

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val a = readLine()!!.split(" ").map { it.toInt() }
        val b = readLine()!!.split(" ").map { it.toInt() }
        if (b.sum() in a[0]..a[1]) {
            println("YES")
        } else {
            println("NO")
        }
    }
}