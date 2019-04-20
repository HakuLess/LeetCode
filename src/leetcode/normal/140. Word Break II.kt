package leetcode.normal

import java.util.LinkedList
import java.util.HashMap


class Solution140 {

    private val cache = HashMap<String, List<String>>()

    private fun containsSuffix(dict: List<String>, str: String): Boolean {
        for (i in 0 until str.length) {
            if (dict.contains(str.substring(i))) {
                return true
            }
        }
        return false
    }

    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        if (cache.containsKey(s)) {
            return cache[s]!!
        }

        val result = LinkedList<String>()
        if (wordDict.contains(s)) {
            result.add(s)
        }
        for (i in 1 until s.length) {
            val left = s.substring(0, i)
            val right = s.substring(i)
            if (wordDict.contains(left) && containsSuffix(wordDict, right)) {
                for (ss in wordBreak(right, wordDict)) {
                    result.add("$left $ss")
                }
            }
        }
        cache[s] = result
        return result
    }
}