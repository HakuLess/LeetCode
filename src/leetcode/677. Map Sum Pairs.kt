package leetcode

import java.util.*

class MapSum() {

    /** Initialize your data structure here. */
    class NTreeNode(var `val`: Char = ' ') {
        var children: HashMap<Char, NTreeNode> = hashMapOf()
        var count = 0
    }

    val root = NTreeNode()

    fun insert(key: String, `val`: Int) {
        var cur = root
        key.forEach {
            if (it !in cur.children.keys) {
                cur.children[it] = NTreeNode(it)
            }
            cur = cur.children[it]!!
        }
        cur.count = `val`
    }

    fun sum(prefix: String): Int {
        var cur = root
        prefix.forEach {
            if (it !in cur.children.keys) {
                return 0
            } else {
                cur = cur.children[it]!!
            }
        }
        return getSum(cur)
    }

    private fun getSum(node: NTreeNode?): Int {
        if (node == null) {
            return 0
        }
        var sum = 0
        val queue: Queue<NTreeNode> = LinkedList()
        queue.add(node)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                sum += item.count
                for (n in item.children) {
                    queue.offer(n.value)
                }
            }
        }

        return sum
    }

}

