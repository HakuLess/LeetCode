package leetcode.contest.cur.b13

import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    val s = Solution5110()
    s.generateSentences(listOf(
            listOf("happy", "joy"),
            listOf("sad", "sorrow"),
            listOf("joy", "cheerful"))
            , "I am happy today but was sad yesterday").forEach {
        it.print()
    }
}

class Solution5110 {

    private fun dfs(map: Map<String, Set<String>>, col: Array<String>, result: ArrayList<String>, index: Int) {
        if (index == col.size) {
            result.add(col.joinToString(" "))
            return
        }
        if (map.containsKey(col[index])) {
            val s = col[index]
            for (sub in map[col[index]]!!) {
                col[index] = sub
                dfs(map, col, result, index + 1)
            }
            col[index] = s
        } else {
            dfs(map, col, result, index + 1)
        }
    }

    fun generateSentences(synonyms: List<List<String>>, text: String): List<String> {
        val map = HashMap<String, Set<String>>()

        for (synonym in synonyms) {
            val s1 = map.getOrDefault(synonym[0], HashSet())
            val s2 = map.getOrDefault(synonym[1], HashSet())
            if (s1 === s2) {
                continue
            }
            val ret = HashSet<String>()
            ret.addAll(s1)
            ret.addAll(s2)
            ret.add(synonym[0])
            ret.add(synonym[1])

            for (sub in ret) {
                map[sub] = ret
            }
        }

        val col = text.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val result = ArrayList<String>()
        dfs(map, col, result, 0)
        return result.sorted()
    }
}