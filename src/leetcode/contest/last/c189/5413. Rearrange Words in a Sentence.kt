package leetcode.contest.last.c189

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5413()
    s.arrangeWords("Leetcode is cool").print()
}

class Solution5413 {
    fun arrangeWords(text: String): String {
        val arr = text.split(" ")
        val map = HashMap<Int, ArrayList<String>>()
        arr.forEach {
            map[it.length] = map.getOrDefault(it.length, ArrayList<String>())
            map[it.length]!!.add(it.toLowerCase())
        }
        var ans = ""
        val keys = map.keys
        keys.sorted().forEach {
            map[it]!!.forEach {
                ans += " $it"
            }
        }
        return ans.trimStart().capitalize()
    }
}