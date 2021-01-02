package leetcode.contest.cur.atcoder.abc187

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val l = HashSet<String>()
    repeat(n) {
        val cur = readLine()!!
        l.add(cur)
    }
    for (i in l) {
        if ("!$i" in l) {
            println("$i")
            return
        }
    }
    println("satisfiable")
}