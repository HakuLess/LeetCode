package leetcode.contest.cur.atcoder.abc175

fun main(args: Array<String>) {
    val n = readLine()!!.toString()
    val list = readLine()!!.toString().split(' ').map { it.toInt() }.sorted()
    var ans = 0
    for (i in 0 until list.lastIndex - 1) {
        for (j in i + 1 until list.lastIndex) {
            for (k in j + 1 until list.size) {
                if (list[i] == list[j] || list[j] == list[k]) continue
                if (list[i] + list[j] > list[k]) {
                    ans++
//                    println("$i, $j, $k")
//                    println("${list[i]}, ${list[j]}, ${list[k]}")
                }
            }
        }
    }
    println(ans)
}