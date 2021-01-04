package leetcode.contest.cur.codeforces.cf693

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        var n = readLine()!!.toInt()
        val arr = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()
        var a = 0L
        var b = 0L
        for (i in arr.indices) {
            if (i % 2 == 0) {
                if (arr[i] % 2 == 0) {
                    a += arr[i]
                }
            } else {
                if (arr[i] % 2 != 0) {
                    b += arr[i]
                }
            }
        }
        when {
            a > b -> {
                println("Alice")
            }
            a == b -> {
                println("Tie")
            }
            else -> {
                println("Bob")
            }
        }
    }
}