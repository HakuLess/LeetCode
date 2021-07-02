package leetcode.contest.cur.leetcode.c247

import leetcode.contest.utils.C
import leetcode.contest.utils.Graph
import leetcode.contest.utils.fac
import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val s = Solution5204()
//    s.waysToBuildRooms(intArrayOf(-1, 0, 1)).print()
//    s.waysToBuildRooms(intArrayOf(-1, 0, 0, 1, 2)).print()
    s.waysToBuildRooms(intArrayOf(-1, 0, 0, 0, 0)).print()
    C(4, 2).print()
//    C(6, 3).print()
}

// TAG: 排列数 乘法逆元
class Solution5204 {
    fun waysToBuildRooms(prevRoom: IntArray): Int {
        val mod = 1000000007L
        val (fac, inv) = fac(prevRoom.size)

        // 构造树
        val g = Graph(prevRoom.size)
        for (i in prevRoom.indices) {
            if (prevRoom[i] == -1) continue
            g.addEdgeOri(prevRoom[i], i)
        }

        val dp = LongArray(prevRoom.size) { 1 }
        val count = IntArray(prevRoom.size) { 0 }

        fun dfs(u: Int) {
            g.adj[u].forEach {
                dfs(it)
                count[u] += count[it]
                dp[u] = (dp[u] * dp[it] % mod * inv[count[it]]) % mod
            }
            dp[u] = dp[u] * fac[count[u]] % mod
            count[u]++
        }
        dfs(0)
        return dp[0].toInt()
    }
}