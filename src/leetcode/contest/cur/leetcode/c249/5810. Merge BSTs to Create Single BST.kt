package leetcode.contest.cur.leetcode.c249

import leetcode.contest.utils.TreeNode
import leetcode.contest.utils.count
import leetcode.contest.utils.isBST

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
class Solution5810 {
    fun canMerge(trees: List<TreeNode>): TreeNode? {
        val arr = IntArray(50005)
        val totalCount = trees.sumBy {
            it.count()
        }
        val mapRoot = hashMapOf<Int, TreeNode>()
        val mapLeaf = hashMapOf<Int, TreeNode>()
        val set = hashSetOf<Int>()
        trees.forEach {
            set.add(it.`val`)
            mapRoot[it.`val`] = it
            arr[it.`val`]++
            it.left?.let {
                mapLeaf[it.`val`] = it
                set.add(it.`val`)
                arr[it.`val`]--
            }
            it.right?.let {
                mapLeaf[it.`val`] = it
                set.add(it.`val`)
                arr[it.`val`]--
            }
        }

        if (totalCount - trees.size + 1 != set.size) return null

        if (arr.count { it == 1 } != 1) return null
        val start = arr.indexOfFirst { it == 1 }
        val root = mapRoot[start]

        // Start Merge
        fun dfs(root: TreeNode?) {
            if (root == null) return
            dfs(mapRoot[root.left?.`val`])
            dfs(mapRoot[root.right?.`val`])

            if (mapRoot[root.left?.`val`] != null)
                root.left = mapRoot[root.left?.`val`]
            if (mapRoot[root.right?.`val`] != null)
                root.right = mapRoot[root.right?.`val`]
        }

        dfs(root)
        return if (root.isBST() && root.count() == set.size) root
        else null
    }
}