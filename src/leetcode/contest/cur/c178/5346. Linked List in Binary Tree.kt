package leetcode.contest.cur.c178

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.TreeNode
import leetcode.contest.utils.find
import java.util.*
import kotlin.collections.ArrayList

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
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
class Solution5346 {
    fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }
        val l = ArrayList<Int>()
        var cur = head
        while (cur != null) {
            l.add(cur.`val`)
            cur = cur.next
        }

        val ans = ArrayList<TreeNode>()

        val queue: Queue<TreeNode?> = LinkedList<TreeNode?>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item != null) {
                    queue.offer(item.left)
                    queue.offer(item.right)
                }
                if (item != null && item.`val` == l[0]) {
                    ans.add(item)
                }
            }
        }

        return helper(ans, l, 1)
    }

    private fun helper(ans: ArrayList<TreeNode>, l: ArrayList<Int>, index: Int): Boolean {
        if (ans.isEmpty()) {
            return false
        }
        if (index > l.lastIndex) {
            return ans.isNotEmpty()
        }
        val next = ArrayList<TreeNode>()
        ans.forEach {
            if (it.left != null && it.left!!.`val` == l[index]) {
                next.add(it.left!!)
            }
            if (it.right != null && it.right!!.`val` == l[index]) {
                next.add(it.right!!)
            }
        }
        return helper(next, l, index + 1)
    }
}