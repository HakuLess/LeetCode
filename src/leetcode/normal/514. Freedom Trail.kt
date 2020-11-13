package leetcode.normal

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution514()
    s.findRotateSteps("godding", "godding").print()
    s.findRotateSteps("caotmcaataijjxi", "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx").print()
}

// 浅薄了
// not finished
class Solution514 {
    fun findRotateSteps(ring: String, key: String): Int {
        val map = HashMap<Char, ArrayList<Int>>()
        val n = ring.length
        for (i in 'a'..'z') {
            map[i] = arrayListOf()
        }
        for (i in ring.indices) {
            map[ring[i]]!!.add(i)
        }
        val memo = HashMap<Pair<Int, Int>, Int>()
        fun dfs(cur: Int, index: Int): Int {
            if (index == key.length) return 0
            val k = Pair(cur, index)
            if (k in memo) {
                return memo[k]!!
            }
            val ch: Char = key[index]
            var ans = Int.MAX_VALUE / 2
            map[ch]?.forEach {
                ans = minOf(ans, minOf(abs(it - cur), n - abs(it - cur)) + 1 + dfs(it, index + 1))
            }
            return ans.also {
                memo[k] = it
            }
        }
        return dfs(0, 0).also {
            memo.forEach { pair, i ->
                println("$pair : $i")
            }
        }
    }

}