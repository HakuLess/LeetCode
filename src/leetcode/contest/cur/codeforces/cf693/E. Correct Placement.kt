package leetcode.contest.cur.codeforces.cf693

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val n = readLine()!!.toInt()
        val arr = ArrayList<Pair<Int, Int>>()
        repeat(n) {
            val (w, h) = readLine()!!.split(' ').map { it.toInt() }.sorted()
            arr.add(Pair(w, h))
        }
        val ans = IntArray(n)
        for (j in ans.indices) {
            ans[j] = arr.indexOfFirst {
                (it.first < arr[j].first && it.second < arr[j].second)
            }
        }
        println(ans.map { if (it != -1) it + 1 else it }.joinToString(" "))
    }
}