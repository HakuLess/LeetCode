package leetcode.contest.cur.atcoder.abc178

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }
    val b = ArrayList(readLine()!!.split(" ").map { it.toInt() })
    for (i in a.indices) {
        if (a[i] == b[i]) {
            for (j in a.indices) {
                if (a[i] != b[j] && b[i] != a[j]) {
                    b[i] = b[j].also {
                        b[j] = b[i]
                    }
                    break
                }
            }
            if (a[i] == b[i]) {
                println("No")
            }
        }
    }
    println("Yes")
    println(b.joinToString(" "))
}