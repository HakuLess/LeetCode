package leetcode.normal

import java.util.*

class Solution117 {
    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    fun connect(root: Node?): Node? {
        if (root == null) return null
        val queue = LinkedList<Node>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in queue.indices) {
                if (i != queue.size - 1) {
                    queue[i].next = queue[i + 1]
                }
            }
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.left != null) {
                    queue.offer(item.left)
                }
                if (item.right != null) {
                    queue.offer(item.right)
                }
            }
        }
        return root
    }
}