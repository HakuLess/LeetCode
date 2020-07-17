package leetcode.normal

import leetcode.contest.utils.TreeNode

/**
 * Created by HaKu on 21/03/2018.
 */

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution100 {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return if (p == null && q == null) {
            true
        } else if (p != null && q != null && p.`val` == q.`val`) {
            (isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
        } else {
            false
        }
    }
}