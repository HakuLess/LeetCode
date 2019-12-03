package leetcode.normal

import leetcode.contest.utils.print

// Not finish
fun main(args: Array<String>) {
    val s = Solution68()
    s.fullJustify(arrayOf("What", "must", "be", "acknowledgment", "shall", "be"), 16)
}

class Solution68 {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val ans = arrayListOf<List<String>>()
        var cur = ""
        val list = arrayListOf<String>()
        words.forEach {
            if (("$cur$it ").length <= maxWidth) {
                cur += "$it "
                list.add(it)
            } else {
                ans.add(list)
                list.clear()
            }
        }
        ans.forEach {
            it.joinToString(" ").print()
        }
        return emptyList()
    }
}