package leetcode.contest.last.c155

import leetcode.contest.utils.UFS
import leetcode.contest.utils.print
import kotlin.collections.HashMap
import java.util.ArrayList


fun main(args: Array<String>) {
    val s = Solution5199()
    s.smallestStringWithSwaps("dcab", listOf(
            listOf(0, 3),
            listOf(1, 2),
            listOf(0, 2)
    )).print()
}

class Solution5199 {
    fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {
        val ufs = UFS(s.length)
        pairs.forEach {
            ufs.union(it[0], it[1])
        }
        val map = HashMap<Int, ArrayList<Char>>()
        for (i in s.indices) {
            map[ufs.find(i)] = map.getOrDefault(ufs.find(i), ArrayList())
            map[ufs.find(i)]!!.add(s[i])
        }
        val ans = CharArray(s.length)
        map.forEach { (_, u) ->
            u.sort()
        }
        for (i in ans.indices) {
            ans[i] = map[ufs.find(i)]!!.first()
            map[ufs.find(i)]!!.removeAt(0)
        }
        return String(ans)
    }
}