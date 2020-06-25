package leetcode.contest.cur.round90

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val size = readLine()!!.toInt()
        val list = readLine()!!.split(" ").map { it.toInt() }.toList()
        val dp0 = arrayListOf<Int>()
        val dp1 = arrayListOf<Int>()

        for (i in list.indices) {
            if (i % 2 == 0) {
                dp0.add(list[i] + if (dp0.isNotEmpty()) dp0.last() else 0)
            } else {
                dp1.add(list[i] + if (dp1.isNotEmpty()) dp1.last() else 0)
            }
        }

//        dp0.toIntArray().print()
//        dp1.toIntArray().print()

        var max = 0
        for (i in dp1.indices) {
            max = maxOf(max, dp1[i] - dp0[i])
        }
//        println("max is $max")

        dp0.clear()
        dp1.clear()
        for (i in list.indices) {
            if (i == 0) continue
            if (i % 2 == 0) {
                dp0.add(list[i] + if (dp0.isNotEmpty()) dp0.last() else 0)
            } else {
                dp1.add(list[i] + if (dp1.isNotEmpty()) dp1.last() else 0)
            }
        }

//        dp0.toIntArray().print()
//        dp1.toIntArray().print()

        for (i in dp0.indices) {
            max = maxOf(max, dp1[i] - dp0[i])
        }
//        println("max is $max")

        println(list.filterIndexed { index, i ->
            index % 2 == 0
        }.sum() + max)

//        var ans = 0
//        for (i in 0 until size step 2) {
//            ans += list[i]
//        }
//        val dp = IntArray(size / 2 + 1)
//        for (i in 0 until size / 2) {
//            dp[i] = list[i * 2 + 1] - list[i * 2] + if (i > 0 && dp[i - 1] >= 0) dp[i - 1] else 0
//        }
//        var max = maxOf(0, dp.max()!!)
//        for (i in 0 until size / 2 - 1) {
//            dp[i] = - list[i * 2 + 2] + list[i * 2 + 1] + if (i > 0 && dp[i - 1] >= 0) dp[i - 1] else 0
//        }
//        max = maxOf(max, dp.max()!!)
//        println(ans + max)
    }
}