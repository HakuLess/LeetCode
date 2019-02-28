package leetcode

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

