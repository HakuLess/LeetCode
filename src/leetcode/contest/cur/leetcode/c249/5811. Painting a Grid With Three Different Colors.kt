package leetcode.contest.cur.leetcode.c249

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5811()
    s.colorTheGrid(1, 2).print()
    s.colorTheGrid(5, 5).print()
}

class Solution5811 {
    fun colorTheGrid(m: Int, n: Int): Int {
        val mod = 1000000007L
        var ans = 0L

        fun dfs3(n: Int): Long {
            var fi0 = 6L
            var fi1 = 6L
            repeat(n - 1) {
                var new_fi0 = (2L * fi0 + 2L * fi1) % mod
                var new_fi1 = (2L * fi0 + 3L * fi1) % mod
                fi0 = new_fi0
                fi1 = new_fi1
            }
            return (fi0 + fi1) % mod
        }

        fun dfs4(n: Int): Long {
            // abab
            var fi0 = 6L
            // abac
            var fi1 = 6L
            // abca
            var fi2 = 6L
            // abcb
            var fi3 = 6L
            repeat(n - 1) {
                var new_fi0 = (3L * fi0 + 2L * fi1 + 1L * fi2 + 2L * fi3) % mod
                var new_fi1 = (2L * fi0 + 2L * fi1 + 1L * fi2 + 1L * fi3) % mod
                var new_fi2 = (1L * fi0 + 1L * fi1 + 3L * fi2 + 1L * fi3) % mod
                var new_fi3 = (2L * fi0 + 2L * fi1 + 1L * fi2 + 2L * fi3) % mod
                fi0 = new_fi0
                fi1 = new_fi1
                fi2 = new_fi2
                fi3 = new_fi3
            }
            return (fi0 + fi1) % mod
        }

        fun dfs5(n: Int): Long {
            // ababa
            var fi0 = 6L
            // ababc
            var fi1 = 6L
            // abaca
            var fi2 = 6L
            // abacb
            var fi3 = 6L
            // abcab
            var fi4 = 6L
            // abcac
            var fi5 = 6L
            // abcba
            var fi6 = 6L
            // abcbc
            var fi7 = 6L
            repeat(n - 1) {
                var new_fi0 = (2L * fi0 + 2L * fi1) % mod
                var new_fi1 = (2L * fi0 + 3L * fi1) % mod
                var new_fi2 = (2L * fi0 + 3L * fi1) % mod
                var new_fi3 = (2L * fi0 + 3L * fi1) % mod
                var new_fi4 = (2L * fi0 + 3L * fi1) % mod
                var new_fi5 = (2L * fi0 + 3L * fi1) % mod
                var new_fi6 = (2L * fi0 + 3L * fi1) % mod
                var new_fi7 = (2L * fi0 + 3L * fi1) % mod
                fi0 = new_fi0
                fi1 = new_fi1
                fi2 = new_fi2
                fi3 = new_fi3
                fi4 = new_fi4
                fi5 = new_fi5
                fi6 = new_fi6
                fi6 = new_fi7
            }
            return (fi0 + fi1) % mod
        }

        fun dfs(a: Int, b: Int): Long {
            if (a == 1 && b == 1) return 3L
            if (a != 1 && b == 1) return (dfs(a - 1, b) * 2L) % mod
            if (b != 1) {
                when (a) {
                    1 -> return (dfs(a, b - 1) * 2L) % mod
                    2 -> return (dfs(a, b - 1) * 3L) % mod
                    3 -> return dfs3(b)
                    4 -> return dfs4(b)
                    else -> return dfs5(b)
                }
            }
            return 0L
        }

        return (dfs(m, n) % mod).toInt()
    }
}