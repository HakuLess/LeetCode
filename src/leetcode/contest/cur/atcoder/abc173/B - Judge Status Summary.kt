package leetcode.contest.cur.atcoder.abc173

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    val map = HashMap<String, Int>()
    map["AC"] = 0
    map["WA"] = 0
    map["TLE"] = 0
    map["RE"] = 0
    for (i in 0 until t) {
        val cur = readLine()!!.toString()
        map[cur] = map[cur]!! + 1
    }
    println("AC x ${map["AC"]}")
    println("WA x ${map["WA"]}")
    println("TLE x ${map["TLE"]}")
    println("RE x ${map["RE"]}")
}