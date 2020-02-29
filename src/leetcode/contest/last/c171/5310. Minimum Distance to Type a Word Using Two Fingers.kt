package leetcode.contest.last.c171

import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5310()
    s.minimumDistance("TMANHNSOJAFWSORCUYAVBZCEMMTFXHURDABMMJFMAVKUNQGQZLTHVBNPQUBGKOXFSGGBGDJYKKXJZEFSXNIBMZZDYSZPFZMZHNYMERUOTWLBUTQHGQMPHSXCRDEFJAKDETUQTZFRNIAYZLEBQGWOVTIYNYBYHSIGKVDWIPLJBIWDLJGKHHGGVMDRIVFLMARVBRNVDIZWGQJXCDQNVRLFEZDJXZXYJFPJHRSWHCPZGLNIKDZEOULQECYOMYPKTJPEJBNWZCOSFCYDMHJUDNUSJRASBMXNQLHYHFU").print()
}

class Solution5310 {
    val map = HashMap<Char, Pair<Int, Int>>()
    val seen = HashMap<Triple<Int, Char?, Char?>, Int>()
    fun minimumDistance(word: String): Int {
        for (i in 'A'..'Z') {
            val index = i - 'A'
            map[i] = Pair(index / 6, index % 6)
        }
        return dfs(word, 0, null, null)
    }

    private fun dfs(word: String, cur: Int, left: Char?, right: Char?): Int {
        if (Triple(cur, left, right) in seen) {
            return seen[Triple(cur, left, right)]!!
        }
        if (cur > word.lastIndex) {
            return 0
        }
        val c1 = if (left == null) 0 else abs(map[left]!!.first - map[word[cur]]!!.first) + abs(map[left]!!.second - map[word[cur]]!!.second)
        val c2 = if (right == null) 0 else abs(map[right]!!.first - map[word[cur]]!!.first) + abs(map[right]!!.second - map[word[cur]]!!.second)

        val ans1 = c1 + dfs(word, cur + 1, word[cur], right)
        val ans2 = c2 + dfs(word, cur + 1, left, word[cur])
        seen[Triple(cur, left, right)] = minOf(ans1, ans2)
        return minOf(ans1, ans2)
    }
}