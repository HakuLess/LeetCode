package leetcode.contest.cur.c190

class Solution5416 {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        val i = sentence.split(" ")
        for (it in i.indices) {
            if (i[it].startsWith(searchWord)) {
                return it + 1
            }
        }
        return -1
    }
}