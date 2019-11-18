package leetcode.contest.cur.c163

import leetcode.contest.utils.TreeNode
import java.util.*

class FindElements(root: TreeNode?) {

    val start = root

    init {
        build(root, 0)
    }

    private fun build(root: TreeNode?, cur: Int) {
        if (root == null) {
            return
        }
        root.`val` = cur
        if (root.left != null) {
            build(root.left, cur * 2 + 1)
        }
        if (root.right != null) {
            build(root.right, cur * 2 + 2)
        }
    }

    fun find(target: Int): Boolean {
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.add(start)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.`val` == target) {
                    return true
                }
                if (item.left != null) {
                    queue.offer(item.left)
                }
                if (item.right != null) {
                    queue.offer(item.right)
                }
            }
        }
        return false
    }

}