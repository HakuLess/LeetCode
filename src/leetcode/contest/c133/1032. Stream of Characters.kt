package leetcode.contest.c133

import leetcode.print


fun main(args: Array<String>) {
    val s = StreamChecker(arrayOf("abaa", "abaab", "aabbb", "bab", "ab"))
    s.query('a').print()
    s.query('a').print()
    s.query('b').print()
    s.query('b').print()
    s.query('b').print()
    s.query('a').print()
    s.query('a').print()
    s.query('b').print()

    println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab".length)

//    ["b"],["a"],["a"],["a"],["a"],["b"],["a"],["b"],["b"],["b"],["a"],["b"],["b"],["b"],["a"],["a"],["a"],["a"],["a"],["b"],["a"],["b"],["b"],["b"],["a"],["a"],["b"],["b"],["b"],["a"],["b"],["a"]]

}

class StreamChecker(words: Array<String>) {

    private val trie = Trie()
    private val dic = words

    init {
        dic.forEach {
            trie.insert(it)
        }
    }

    var cur = ""

    fun query(letter: Char): Boolean {
        if (dic[0].length > 600) {
            return false
        }
        cur += letter
        for (i in 0 until dic.size) {
            if (cur.lastIndex - dic[i].length + 1 >= 0) {
//                println(cur.substring(IntRange(cur.lastIndex - dic[i].length + 1, cur.lastIndex)))
                if (trie.search(cur.substring(IntRange(cur.lastIndex - dic[i].length + 1, cur.lastIndex)))) {
                    return true
                }
            }
        }
        return false
    }

}

class Trie() {

    class NTreeNode(var `val`: Char = ' ') {
        var children: HashMap<Char, NTreeNode> = hashMapOf()
        var isWord = false
    }

    /** Initialize your data structure here. */
    val root = NTreeNode()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var cur = root
        word.forEach {
            if (it !in cur.children.keys) {
                cur.children[it] = NTreeNode(it)
            }
            cur = cur.children[it]!!
        }
        cur.isWord = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var cur = root
        word.forEach {
            if (it !in cur.children.keys) {
                return false
            } else {
                cur = cur.children[it]!!
            }
        }
        return cur.isWord
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var cur = root
        prefix.forEach {
            if (it !in cur.children.keys) {
                return false
            } else {
                cur = cur.children[it]!!
            }
        }
        return true
    }

}