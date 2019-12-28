package leetcode.contest.cur.b16

import leetcode.contest.utils.TreeNode
import java.util.*

class Solution {
    fun deepestLeavesSum(root: TreeNode?): Int {
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.add(root)
        var ans = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            if (queue.isEmpty()) {
                return ans
            }
            ans = 0
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.left != null) {
                    queue.offer(item.left)
                }
                if (item.right != null) {
                    queue.offer(item.right)
                }
                ans += item.`val`
            }
        }
        return ans
    }
}