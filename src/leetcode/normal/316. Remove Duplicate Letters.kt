package leetcode.normal

import java.lang.StringBuilder
import java.util.*

class Solution316 {
    val ans = StringBuilder()
    fun removeDuplicateLetters(text: String): String {
        val count = hashMapOf<Char, Int>()
        text.forEach {
            count[it] = count.getOrDefault(it, 0) + 1
        }
        val seen = TreeMap<Char, Int>()
        for (i in text.indices) {
            if (!seen.containsKey(text[i])) {
                seen[text[i]] = i
            }
            count[text[i]] = count[text[i]]!!.minus(1)
            if (count[text[i]] == 0) {
                val remove = seen.firstEntry()
                ans.append(remove.key)
                val sb = text.substring(IntRange(remove.value + 1, text.lastIndex))
                        .filter {
                            it != remove.key
                        }
                return removeDuplicateLetters(sb)
            }
        }
        return ans.toString()
    }
}