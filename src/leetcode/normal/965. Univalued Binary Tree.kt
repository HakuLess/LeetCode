package leetcode.normal

import leetcode.TreeNode

fun isUnivalTree(root: TreeNode?): Boolean {

    if (root == null) {
        return true
    }
    return isUnivalTree(root.left, root.`val`) && isUnivalTree(root.right, root.`val`)
}

fun isUnivalTree(root: TreeNode?, value: Int): Boolean {
    return when {
        root == null -> {
            true
        }
        root.`val` == value -> {
            isUnivalTree(root.left, root.`val`) && isUnivalTree(root.right, root.`val`)
        }
        else -> {
            false
        }
    }
}