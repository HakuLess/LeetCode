package leetcode.contest.c140

import leetcode.print
import java.lang.StringBuilder
import java.util.*

fun main(args: Array<String>) {
    val a = Solution5086()
//    a.smallestSubsequence("cdadabcc").print()
//    a.smallestSubsequence("abcd").print()
//    a.smallestSubsequence("ecbacba").print()
//    a.smallestSubsequence("leetcode").print()
    a.smallestSubsequence("cbaacabcaaccaacababa").print()
}

class Solution5086 {
    val ans = StringBuilder()

    fun smallestSubsequence(text: String): String {
        text.print()
        val count = hashMapOf<Char, Int>()
        text.forEach {
            count[it] = count.getOrDefault(it, 0) + 1
        }

        val seen = TreeMap<Char, Int>()
        for (i in 0 until text.length) {
            if (count.containsKey(text[i])) {
                if (!seen.containsKey(text[i])) {
                    seen[text[i]] = i
                }
                count[text[i]] = count[text[i]]!!.minus(1)
                if (count[text[i]] == 0) {
                    val remove = seen.firstEntry()
                    ans.append(remove.key)
                    count.remove(remove.key)
                    val sb = text.substring(IntRange(remove.value + 1, text.lastIndex))
                            .filter {
                                it != remove.key
                            }
                    return smallestSubsequence(sb)
                }
            }
        }
        return ans.toString()
    }
}