package leetcode.normal

import leetcode.contest.utils.TreeNode
import java.util.*


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
class Solution99 {
    fun recoverTree(root: TreeNode?) {
        var root = root
        val stack: Deque<TreeNode> = ArrayDeque()
        var x: TreeNode? = null
        var y: TreeNode? = null
        var pred: TreeNode? = null
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root)
                root = root.left
            }
            root = stack.pop()
            if (pred != null && root.`val` < pred.`val`) {
                y = root
                x = if (x == null) {
                    pred
                } else {
                    break
                }
            }
            pred = root
            root = root.right
        }
        swap(x, y)
    }

    fun swap(x: TreeNode?, y: TreeNode?) {
        val tmp = x!!.`val`
        x.`val` = y!!.`val`
        y.`val` = tmp
    }
}