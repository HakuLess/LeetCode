package leetcode.contest.cur.atcoder.abc175

fun main(args: Array<String>) {
    val (r, c, k) = readLine()!!.toString().split(' ').map { it.toInt() }
    val matrix = Array<LongArray>(r) { LongArray(c) }
    for (i in 0 until k) {
        val (r, c, v) = readLine()!!.toString().split(' ').map { it.toInt() }
        matrix[r - 1][c - 1] = v.toLong()
    }

    val dp = Array<Array<LongArray>>(r) { Array<LongArray>(c) { LongArray(4) } }

    for (i in 0 until r) {
        for (j in 0 until c) {
            if (i > 0)
                for (k in 0..3)
                    dp[i][j][0] = maxOf(dp[i][j][0], dp[i - 1][j][k])
            if (j > 0)
                for (k in 0..3)
                    dp[i][j][k] = maxOf(dp[i][j][k], dp[i][j - 1][k])

            for (k in 3 downTo 1)
                dp[i][j][k] = maxOf(dp[i][j][k], dp[i][j][k - 1] + matrix[i][j])
        }
    }
    println(dp.last().last().maxOrNull()!!)
}