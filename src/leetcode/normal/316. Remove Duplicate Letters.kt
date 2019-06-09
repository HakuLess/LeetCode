package leetcode.normal

import java.lang.StringBuilder
import java.util.*

class Solution316 {
    val ans = StringBuilder()

    fun removeDuplicateLetters(s: String): String {
        val count = hashMapOf<Char, Int>()
        s.forEach {
            count[it] = count.getOrDefault(it, 0) + 1
        }

        val seen = TreeMap<Char, Int>()
        for (i in 0 until s.length) {
            if (count.containsKey(s[i])) {
                if (!seen.containsKey(s[i])) {
                    seen[s[i]] = i
                }
                count[s[i]] = count[s[i]]!!.minus(1)
                if (count[s[i]] == 0) {
                    val remove = seen.firstEntry()
                    ans.append(remove.key)
                    count.remove(remove.key)
                    val sb = s.substring(IntRange(remove.value + 1, s.lastIndex))
                            .filter {
                                it != remove.key
                            }
                    return removeDuplicateLetters(sb)
                }
            }
        }
        return ans.toString()
    }
}