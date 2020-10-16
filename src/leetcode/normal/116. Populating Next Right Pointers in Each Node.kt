package leetcode.normal

import java.util.*

class Solution116 {
    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    fun connect(root: Node?): Node? {
        if (root == null) return null
        val queue: Queue<Node> = LinkedList<Node>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            var last: Node? = null
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.left != null) {
                    queue.offer(item.left)
                }
                if (item.right != null) {
                    queue.offer(item.right)
                }
                last?.next = item
                last = item
            }
        }
        return root
    }
}