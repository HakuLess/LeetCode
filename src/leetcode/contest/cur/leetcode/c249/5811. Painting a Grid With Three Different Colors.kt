package leetcode.contest.cur.leetcode.c249

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5811()
//    s.colorTheGrid(1, 2).print()
    s.colorTheGrid(5, 5).print()
    s.colorTheGrid(3, 49).print()
}

class Solution5811 {
    fun colorTheGrid(m: Int, n: Int): Int {
        val mod = 1000000007L

        var set = hashSetOf<String>("1", "2", "3")
        repeat(m - 1) {
            val next = hashSetOf<String>()
            for (i in '1'..'3') {
                set.forEach {
                    if (it.last() != i) {
                        next.add("$it$i")
                    }
                }
            }
            set = next
        }

        val map = HashMap<String, ArrayList<String>>()
        set.forEach { a ->
            map[a] = arrayListOf()
            set.forEach { b ->
                if ((0 until m).all { a[it] != b[it] }) {
                    map[a]!!.add(b)
                }
            }
        }

        var ans = 0L
        val seen = HashMap<String, Long>()
        fun dfs(cur: String, level: Int): Long {
            val key = "${cur}_$level"
            if (key in seen) {
                return seen[key]!!
            }
            if (level == n) return 1L
            var ans = 0L
            map[cur]!!.forEach {
                ans += dfs(it, level + 1)
                ans %= mod
            }
            return ans.also {
                seen[key] = it
            }
        }
        set.forEach {
            ans += dfs(it, 1)
            ans %= mod
        }
        return (ans % mod).toInt()
    }

//    fun colorTheGrid(m: Int, n: Int): Int {
//        val mod = 1000000007L
//
//        val arr3 = LongArray(2) { 6L }
//        val p3 = arrayOf(
//            longArrayOf(2L, 2L),
//            longArrayOf(2L, 3L)
//        )
//
//        val arr4 = LongArray(4) { 6L }
//        val p4 = arrayOf(
//            longArrayOf(2L, 2L, 1L, 2L),
//            longArrayOf(2L, 3L, 1L, 2L),
//            longArrayOf(1L, 1L, 2L, 1L),
//            longArrayOf(2L, 2L, 1L, 2L)
//        )
//
//        val arr5 = LongArray(8) { 6L }
//        val p5 = arrayOf(
//            longArrayOf(2L, 1L, 2L, 2L, 0L, 1L, 2L, 2L),
//            longArrayOf(1L, 2L, 1L, 1L, 1L, 1L, 1L, 1L),
//            longArrayOf(2L, 1L, 3L, 2L, 0L, 1L, 2L, 2L),
//            longArrayOf(2L, 1L, 2L, 2L, 1L, 1L, 1L, 1L),
//            longArrayOf(0L, 1L, 0L, 1L, 2L, 1L, 0L, 1L),
//            longArrayOf(1L, 1L, 1L, 1L, 1L, 2L, 1L, 1L),
//            longArrayOf(2L, 1L, 2L, 1L, 0L, 1L, 2L, 1L),
//            longArrayOf(2L, 1L, 2L, 1L, 1L, 1L, 1L, 2L)
//        )
//
//        fun cal(n: Int, arr: LongArray, p: Array<LongArray>): Long {
//            var cur = arr
//            repeat(n - 1) {
//                val next = LongArray(cur.size)
//                for (i in next.indices) {
//                    for (j in cur.indices) {
//                        next[i] = (next[i] + p[i][j] * cur[j]) % mod
//                    }
//                }
//                cur = next
//            }
//            var res = 0L
//            for (i in cur.indices) {
//                res = (res + cur[i]) % mod
//            }
//            return res
//        }
//
//        fun dfs(a: Int, b: Int): Long {
//            if (a == 1 && b == 1) return 3L
//            if (a != 1 && b == 1) return (dfs(a - 1, b) * 2L) % mod
//            if (b != 1) {
//                when (a) {
//                    1 -> return (dfs(a, b - 1) * 2L) % mod
//                    2 -> return (dfs(a, b - 1) * 3L) % mod
//                    3 -> return cal(b, arr3, p3)
//                    4 -> return cal(b, arr4, p4)
//                    else -> return cal(b, arr5, p5)
//                }
//            }
//            return 0L
//        }
//        return (dfs(m, n) % mod).toInt()
//    }
}