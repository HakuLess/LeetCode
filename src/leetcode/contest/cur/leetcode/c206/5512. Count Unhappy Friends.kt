package leetcode.contest.cur.leetcode.c206

class Solution5512 {
    fun unhappyFriends(n: Int, preferences: Array<IntArray>, pairs: Array<IntArray>): Int {
        val arr = Array<IntArray>(n) {
            IntArray(n) { 0 }
        }
        for (i in preferences.indices) {
            for (j in preferences[i].indices) {
                arr[i][preferences[i][j]] = n - j
            }
        }

        fun check(x: Int, y: Int, u: Int, v: Int): Boolean {
            return arr[x][u] > arr[x][y] && arr[u][x]>arr[u][v]
        }
        val set = HashSet<Int>()
        for (i in pairs.indices) {
            for (j in i + 1 until pairs.size) {
                val x = pairs[i][0]
                val y = pairs[i][1]
                val u = pairs[j][0]
                val v = pairs[j][1]
                if (check(x, y, u, v)) set.add(x)
                if (check(x, y, v, u)) set.add(x)
                if (check(y, x, u, v)) set.add(y)
                if (check(y, x, v, u)) set.add(y)
                if (check(u, v, x, y)) set.add(u)
                if (check(u, v, y, x)) set.add(u)
                if (check(v, u, x, y)) set.add(v)
                if (check(v, u, y, x)) set.add(v)
            }
        }
        return set.size
    }
}