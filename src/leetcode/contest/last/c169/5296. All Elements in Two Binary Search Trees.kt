package leetcode.contest.last.c169

import leetcode.contest.utils.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution5296 {
    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val l1 = add(root1)
        val l2 = add(root2)
        val ans = arrayListOf<Int>()
        ans.addAll(l1)
        ans.addAll(l2)
        return ans.sorted()
    }

    private fun add(root: TreeNode?): ArrayList<Int> {
        val queue: Queue<TreeNode?> = LinkedList<TreeNode?>()
        queue.add(root)
        val ans = ArrayList<Int>()
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item != null) {
                    ans.add(item.`val`)
                }
                if (item?.left != null)
                    queue.offer(item.left)
                if (item?.right != null)
                    queue.offer(item.right)
            }
        }
        return ans
    }
}