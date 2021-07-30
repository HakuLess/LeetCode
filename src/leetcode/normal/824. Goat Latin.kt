package leetcode.normal

import java.lang.StringBuilder

class Solution824 {
    fun toGoatLatin(sentence: String): String {
        return sentence.split(" ").mapIndexed { index, s ->
            val next: StringBuilder
            if (s[0] in arrayOf(
                    'a', 'e', 'i', 'o', 'u',
                    'A', 'E', 'I', 'O', 'U'
                )
            ) {
                next = StringBuilder(s)
                next.append("ma")
            } else {
                next = StringBuilder(s.takeLast(s.length - 1))
                next.append(s[0])
                next.append("ma")
            }
            repeat(index + 1) {
                next.append('a')
            }
            next.toString()
        }.joinToString(" ")
    }
}