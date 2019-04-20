package leetcode.normal

import java.util.*

class WordDictionary() {

    /** Initialize your data structure here. */
    class NTreeNode(var `val`: Char = ' ') {
        var children: HashMap<Char, NTreeNode> = hashMapOf()
        var isWord = false
    }

    val root = NTreeNode()

    /** Adds a word into the data structure. */
    fun addWord(word: String) {
        var cur = root
        word.forEach {
            if (it !in cur.children.keys) {
                cur.children[it] = NTreeNode(it)
            }
            cur = cur.children[it]!!
        }
        cur.isWord = true
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    fun search(word: String): Boolean {
        val queue: Queue<NTreeNode> = LinkedList()
        queue.add(root)

        word.forEach {
            val size = queue.size
            if (size == 0) {
                return false
            }
            for (i in 0 until size) {
                val item = queue.poll()
                if (it == '.') {
                    for (child in item.children.values) {
                        queue.offer(child)
                    }
                } else {
                    if (item.children.containsKey(it)) {
                        queue.offer(item.children[it])
                    }
                }
            }
        }
        return queue.any { it.isWord }
    }

}