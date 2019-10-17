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
        val map = HashMap<Int, ArrayList<Int>>()
        for (i in 0 until s.length) {
            map[ufs.find(i)] = map.getOrDefault(ufs.find(i), ArrayList())
            map[ufs.find(i)]!!.add(i)
        }

        val ans = CharArray(s.length)
        map.forEach { (_, u) ->
            val temp = ArrayList<Char>()
            u.forEach {
                temp.add(s[it])
            }
            temp.sort()
            for (i in 0 until temp.size) {
                ans[u[i]] = temp[i]
            }
        }
        return String(ans)
    }
}