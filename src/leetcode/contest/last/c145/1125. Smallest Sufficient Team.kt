package leetcode.contest.last.c145

import leetcode.contest.utils.print
import java.util.ArrayList
import java.util.HashMap


fun main(args: Array<String>) {
    val s = Solution1125()
    s.smallestSufficientTeam(
            arrayOf("java", "nodejs", "reactjs"),
            listOf(
                    listOf("java"),
                    listOf("nodejs"),
                    listOf("nodejs", "reactjs")
            )
    ).print()
}

class Solution1125 {
    fun smallestSufficientTeam(req_skills: Array<String>, people: List<List<String>>): IntArray {
        val map = HashMap<String, Int>()
        var k = 0
        req_skills.forEach {
            map[it] = 1 shl k++
        }
        val sk = req_skills.map { map[it]!! }
        val p = people.map { it.map { map.getOrDefault(it, 0) }.sum() }
        val n = sk.size
        val dp = Array<HashSet<Int>>(1 shl n) { hashSetOf() }
        for (i in p.indices) {
            if (p[i] == 0) continue
            for (j in 0 until (1 shl n)) {
                if (j != 0 && dp[j].isEmpty()) continue
                val take = p[i] or j
                if (dp[take].isEmpty() || dp[j].size + 1 < dp[take].size) {
                    dp[take] = HashSet(dp[j])
                    dp[take].add(i)
                }
            }
        }
        return dp.last().toIntArray()
    }
}