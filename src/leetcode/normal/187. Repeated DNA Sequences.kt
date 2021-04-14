package leetcode.normal

import leetcode.contest.utils.Trie

class Solution187 {
    fun findRepeatedDnaSequences(s: String): List<String> {
        val cur = arrayListOf<Char>()
        val trie = Trie<Char>()
        val ans = HashSet<String>()
        s.forEach {
            cur.add(it)
            if (cur.size > 10) {
                cur.removeAt(0)
            }
            if (trie.search(cur.toTypedArray())) {
                ans.add(cur.joinToString(""))
            } else {
                trie.insert(cur.toTypedArray())
            }
        }
        return ans.toList()
    }
}