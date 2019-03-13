package leetcode

fun main(args: Array<String>) {
    val s = Solution808()
    s.soupServings(501).print()
}

class Solution808 {

//    fun soupServings(N: Int): Double {
//        var N = N
//        N = N / 25 + if (N % 25 > 0) 1 else 0
//        if (N >= 500) return 1.0
//
//        val memo = Array(N + 1) { DoubleArray(N + 1) }
//        for (s in 0..2 * N) {
//            for (i in 0..N) {
//                val j = s - i
//                if (j < 0 || j > N) continue
//                var ans = 0.0
//                if (i == 0) ans = 1.0
//                if (i == 0 && j == 0) ans = 0.5
//                if (i > 0 && j > 0) {
//                    ans = 0.25 * (memo[M(i - 4)][j] + memo[M(i - 3)][M(j - 1)] +
//                            memo[M(i - 2)][M(j - 2)] + memo[M(i - 1)][M(j - 3)])
//                }
//                memo[i][j] = ans
//
//            }
//        }
//        return memo[N][N]
//    }
//
//    fun M(x: Int): Int {
//        return Math.max(0, x)
//    }
//    fun soupServings(N: Int): Double {
//        val n = N / 25 + if (N % 25 == 0) 0 else 1
//        val dp = Array(n + 1) { DoubleArray(n + 1) }
//        for (s in 0..2 * n) {
//            for (i in 0..n) {
//                val j = s - i
//                if (j < 0 || j > n) {
//                    continue
//                }
//                var ans = 0.0
//                if (i == 0) {
//                    ans = 1.0
//                }
//                if (i == 0 && j == 0) {
//                    ans = 0.5
//                }
//                if (i > 0 && j > 0) {
//                    ans = 0.25 * (
//                            dp[maxOf(0, i - 4)][j] +
//                                    dp[maxOf(0, i - 1)][maxOf(0, j - 3)] +
//                                    dp[maxOf(0, i - 2)][maxOf(0, j - 2)] +
//                                    dp[maxOf(0, i - 3)][maxOf(0, j - 1)])
//                }
//                dp[i][j] = ans
//            }
//        }
//        return dp[n][n]
//    }
    val map = HashMap<Pair<Int, Int>, Double>()

    fun soupServings(N: Int): Double {
        if (N > 500) {
            return 1.0
        }
        return serve(N, N)
    }

    private fun serve(a: Int, b: Int): Double {
        if (Pair(a, b) in map) {
            return map[Pair(a, b)]!!
        }
        val ans = if (a <= 0 && b > 0) {
            1.0
        } else if (a <= 0 && b <= 0) {
            0.5
        } else if (a > 0 && b <= 0) {
            0.0
        } else {
            (serve(a - 100, b) +
                    serve(a - 75, b - 25) +
                    serve(a - 50, b - 50) +
                    serve(a - 25, b - 75)) * 0.25
        }
        map[Pair(a, b)] = ans
        println("$a, $b, $ans")
        return ans
    }
}