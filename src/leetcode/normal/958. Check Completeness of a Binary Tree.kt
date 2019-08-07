package leetcode.normal

import leetcode.contest.utils.TreeNode
import java.util.*

class Solution958 {
    fun isCompleteTree(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        val queue: Queue<TreeNode?> = LinkedList()
        queue.add(root)
        var end = false
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item == null) {
                    end = true
                } else {
                    if (end) {
                        return false
                    }
                    queue.offer(item.left)
                    queue.offer(item.right)
                }
            }
        }
        return true
    }
}