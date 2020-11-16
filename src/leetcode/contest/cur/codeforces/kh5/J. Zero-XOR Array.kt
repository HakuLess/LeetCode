package leetcode.contest.cur.codeforces.kh5

fun main(args: Array<String>) {
    val n = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }.sorted()
    var cur = 0
    arr.forEach {
        cur = cur xor it
    }
    println(cur)
}