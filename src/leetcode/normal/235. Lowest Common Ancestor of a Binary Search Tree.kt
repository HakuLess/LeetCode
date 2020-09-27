package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution235 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        return if (root!!.`val` < p!!.`val` && root.`val` < q!!.`val`)
             lowestCommonAncestor(root.right, p, q)
        else if (root.`val` > p.`val` && root.`val` > q!!.`val`)
            lowestCommonAncestor(root.left, p, q)
        else root
    }
}