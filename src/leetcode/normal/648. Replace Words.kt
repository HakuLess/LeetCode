package leetcode.normal

class Solution648 {
    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val sorted = dictionary.sortedBy { it }
        return sentence.split(' ').joinToString(" ") { str ->
            sorted.firstOrNull { str.startsWith(it) } ?: str
        }
    }
}