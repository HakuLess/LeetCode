package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5018()
    s.camelMatch(arrayOf("FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"), "FB").print()
}

class Solution5018 {
    fun camelMatch(queries: Array<String>, pattern: String): BooleanArray {
        fun valid(str: String, pattern: String): Boolean {
            var i = 0
            var j = 0
            while (i < str.length && j < pattern.length) {
                when {
                    str[i] == pattern[j] -> {
                        i++
                        j++
                    }
                    str[i].isLowerCase() -> i++
                    str[i].isUpperCase() -> return false
                }
            }

            if (j != pattern.length) {
                return false
            } else {
                if (str.substring(i).any { it.isUpperCase() }) {
                    return false
                }
            }
            return true
        }

        val ans = arrayListOf<Boolean>()
        queries.forEach {
            ans.add(valid(it, pattern))
        }
        return ans.toBooleanArray()
    }
}