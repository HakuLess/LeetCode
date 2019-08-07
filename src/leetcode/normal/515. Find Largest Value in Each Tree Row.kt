package leetcode.normal

import leetcode.contest.utils.TreeNode
import java.util.*

class Solution515 {
    fun largestValues(root: TreeNode?): List<Int> {

        if (root == null) {
            return emptyList()
        }

        val ans = arrayListOf<Int>()
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            var max = queue.peek().`val`
            for (i in 0 until size) {
                val item = queue.poll()
                max = maxOf(max, item.`val`)
                if (item.left != null) {
                    queue.add(item.left)
                }
                if (item.right != null) {
                    queue.add(item.right)
                }
            }
            ans.add(max)
        }

        return ans
    }
}