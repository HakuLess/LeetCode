package leetcode.normal

import java.util.*

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution559 {
    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    fun maxDepth(root: Node?): Int {
        val queue: Queue<Node> = LinkedList<Node>()
        if (root != null)
            queue.add(root)
        var step = 0
        while (queue.isNotEmpty()) {
            step++
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                item.children.filterNotNull().forEach {
                    queue.offer(it)
                }
            }
        }
        return step
    }
}