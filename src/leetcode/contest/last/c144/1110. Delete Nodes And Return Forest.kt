package leetcode.contest.last.c144

import leetcode.contest.utils.TreeNode
import java.util.*

class Solution1110 {
    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
        if (root == null) {
            return emptyList()
        }
        val ans = arrayListOf<TreeNode>()
        val queue: Queue<TreeNode?> = LinkedList()
        queue.add(root)
        if (root.`val` !in to_delete) {
            ans.add(root)
        }
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll() ?: continue
                queue.offer(item.left)
                queue.offer(item.right)

                if (item.`val` in to_delete) {
                    if (item.left != null && item.left!!.`val` !in to_delete) {
                        ans.add(item.left!!)
                    }
                    if (item.right != null && item.right!!.`val` !in to_delete) {
                        ans.add(item.right!!)
                    }
                }
            }
        }

        dfs(root, to_delete)
        return ans
    }

    private fun dfs(root: TreeNode?, to_delete: IntArray) {
        if (root == null) {
            return
        }
        dfs(root.left, to_delete)
        dfs(root.right, to_delete)

        if (root.left != null && root.left!!.`val` in to_delete) {
            root.left = null
        }
        if (root.right != null && root.right!!.`val` in to_delete) {
            root.right = null
        }
    }
}