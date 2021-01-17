package leetcode.normal

import leetcode.contest.utils.TreeNode
import java.util.*

class Solution513 {
    fun findBottomLeftValue(root: TreeNode?): Int {
        if (root == null) return 0
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.add(root)
        var ans = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            ans = queue.peek().`val`
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
        return ans
    }
}