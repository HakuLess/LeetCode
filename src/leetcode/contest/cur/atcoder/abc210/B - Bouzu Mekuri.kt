package leetcode.contest.cur.atcoder.abc210

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    s.indexOfFirst { it == '1' }.let {
        if (it % 2 == 0) {
            println("Takahashi")
        } else {
            println("Aoki")
        }
    }
}