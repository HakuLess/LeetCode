package leetcode.contest.cur.c180

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
class Solution5179 {
    fun balanceBST(root: TreeNode?): TreeNode? {
        val root = buildTree(root)
        preOrder(root)
        return root
    }

    private fun storeBSTNodes(root: TreeNode?, nodes: Vector<TreeNode>) {
        if (root == null) return
        storeBSTNodes(root.left, nodes)
        nodes.add(root)
        storeBSTNodes(root.right, nodes)
    }

    private fun buildTreeUtil(nodes: Vector<TreeNode>, start: Int, end: Int): TreeNode? {
        if (start > end) return null
        val mid = (start + end) / 2
        val node: TreeNode = nodes[mid]
        node.left = buildTreeUtil(nodes, start, mid - 1)
        node.right = buildTreeUtil(nodes, mid + 1, end)
        return node
    }

    private fun buildTree(root: TreeNode?): TreeNode? {
        val nodes: Vector<TreeNode> = Vector<TreeNode>()
        storeBSTNodes(root, nodes)
        val n = nodes.size
        return buildTreeUtil(nodes, 0, n - 1)
    }

    private fun preOrder(node: TreeNode?) {
        if (node == null) return
        preOrder(node.left)
        preOrder(node.right)
    }
}