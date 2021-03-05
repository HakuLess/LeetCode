package leetcode.normal

import leetcode.contest.utils.Trie
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = MagicDictionary()
//    s.buildDict(arrayOf("ab", "a", "b"))
    s.buildDict(arrayOf("hello", "leetcode"))
    s.search("hello").print()
    s.search("hhllo").print()
    s.search("leetcodd").print()
}

class MagicDictionary() {

    /** Initialize your data structure here. */
    private val trie = Trie<Char>()

    fun buildDict(dictionary: Array<String>) {
        dictionary.forEach {
            trie.insert(it.toCharArray().toTypedArray())
        }
//        trie.print()
    }

    fun search(searchWord: String): Boolean {
        fun dfs(node: Trie.TrieNode<Char>, i: Int, skip: Boolean): Boolean {
            if (i != -1) {
                if (skip && node.value != searchWord[i]) return false
                if (i == searchWord.lastIndex) return (node.isEnd && (skip or (node.value != searchWord[i])))
            }
            node.children.forEach {
                if (dfs(it, i + 1, skip or (if (i == -1) false else node.value != searchWord[i]))) {
                    return true
                }
            }
            return false
        }
        return dfs(trie.root, -1, false)
    }

}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * var obj = MagicDictionary()
 * obj.buildDict(dictionary)
 * var param_2 = obj.search(searchWord)
 */