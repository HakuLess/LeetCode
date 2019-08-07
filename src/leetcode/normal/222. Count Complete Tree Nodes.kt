package leetcode.normal

import leetcode.contest.utils.TreeNode
import java.util.*

class Solution222 {

    fun countNodes(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var ans = 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val count = queue.size
            ans += count
            for (i in 0 until count) {
                val item = queue.poll()
                if (item.left != null) {
                    queue.add(item.left)
                }
                if (item.right != null) {
                    queue.add(item.right)
                }
            }
        }
        return ans
    }

}