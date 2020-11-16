package leetcode.contest.cur.codeforces.kh5

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val n = readLine()!!.toInt()
        val arr = readLine()!!.split(" ").map { it.toInt() }
        val l = arrayListOf<Pair<Int, Int>>()
        for (i in arr.indices) {
            l.add(Pair(arr[i], i + 1))
        }
        val sorted = l.sortedBy { it.first }
        var left = 0
        var right = sorted.lastIndex
        var cur = 0
        val ans = arrayListOf<Int>()
        while (ans.size != sorted.size) {
//            println("$cur ${l[left]}")
            if (cur < sorted[left].first) {
//                println("add right ${sorted[right].second}")
                ans.add(sorted[right].second)
                right--
                cur++
            } else {
//                println("add left ${sorted[left].second}")
                ans.add(sorted[left].second)
                left++
                cur = 1
            }
        }
        println(ans.joinToString(" "))
    }
}