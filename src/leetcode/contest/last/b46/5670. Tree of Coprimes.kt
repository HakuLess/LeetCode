package leetcode.contest.last.b46

import leetcode.contest.utils.gcd
import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution5670()
    s.getCoprimes(intArrayOf(2, 3, 3, 2), "[[0,1],[1,2],[1,3]]".toGrid()).print()
    s.getCoprimes(intArrayOf(9, 16, 30, 23, 33, 35, 9, 47, 39, 46, 16, 38, 5, 49, 21, 44, 17, 1, 6, 37, 49, 15, 23, 46, 38, 9, 27, 3, 24, 1, 14, 17, 12, 23, 43, 38, 12, 4, 8, 17, 11, 18, 26, 22, 49, 14, 9), "[[17,0],[30,17],[41,30],[10,30],[13,10],[7,13],[6,7],[45,10],[2,10],[14,2],[40,14],[28,40],[29,40],[8,29],[15,29],[26,15],[23,40],[19,23],[34,19],[18,23],[42,18],[5,42],[32,5],[16,32],[35,14],[25,35],[43,25],[3,43],[36,25],[38,36],[27,38],[24,36],[31,24],[11,31],[39,24],[12,39],[20,12],[22,12],[21,39],[1,21],[33,1],[37,1],[44,37],[9,44],[46,2],[4,46]]".toGrid()).print()
}

class Solution5670 {
    fun getCoprimes(nums: IntArray, edges: Array<IntArray>): IntArray {
        val n = edges.size + 1
        val map = HashMap<Int, ArrayList<Int>>()
        edges.forEach {
            map[it[0]] = map.getOrDefault(it[0], arrayListOf())
            map[it[0]]!!.add(it[1])
            map[it[1]] = map.getOrDefault(it[1], arrayListOf())
            map[it[1]]!!.add(it[0])
        }
        val seen = HashSet<Int>()
        val ans = IntArray(n) { -1 }
        fun dfs(cur: Int, step: Int, preList: Array<Pair<Int, Int>>) {
            if (cur in seen) return
            seen.add(cur)
            var max = -1
            for (i in 1..50) {
                if (gcd(i, nums[cur]) == 1) {
                    if (preList[i].second > max) {
                        ans[cur] = preList[i].first
                        max = preList[i].second
                    }
                }
            }
            map[cur]?.forEach {
                val next = preList.clone()
                next[nums[cur]] = Pair(cur, step)
                dfs(it, step + 1, next)
            }
        }
        dfs(0, 0, Array(51) { Pair(-1, -1) })
        return ans
    }
}