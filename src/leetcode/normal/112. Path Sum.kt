package leetcode.normal

import leetcode.TreeNode

fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
    if (root == null) {
        return false
    }
    if (root.left == null && root.right == null && sum == root.`val`) {
        return true
    }

    return hasPathSum(root.left, sum - root.`val`) || hasPathSum(root.right, sum - root.`val`)
}