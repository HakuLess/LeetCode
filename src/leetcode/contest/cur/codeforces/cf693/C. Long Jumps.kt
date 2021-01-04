package leetcode.contest.cur.codeforces.cf693

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        var n = readLine()!!.toInt()
        val arr = readLine()!!.split(" ").map { it.toInt() }
        val dp = IntArray(arr.size)
        for (index in arr.indices.reversed()) {
            dp[index] = if (index + arr[index] in arr.indices)
                arr[index] + dp[index + arr[index]]
            else
                arr[index]
        }
        println(dp.max())
    }
}