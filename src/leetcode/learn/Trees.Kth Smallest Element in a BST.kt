package leetcode.learn

import leetcode.TreeNode

fun kthSmallest(root: TreeNode?, k: Int): Int {
    if (root == null) {
        return 0
    }
    val count = getNodeCount(root.left)
    return when {
        count == k - 1 -> {
            root.`val`
        }
        count > k - 1 -> {
            kthSmallest(root.left, k)
        }
        else -> {
            kthSmallest(root.right, k - count)
        }
    }
}

fun getNodeCount(root: TreeNode?): Int {
    return if (root == null) {
        0
    } else {
        1 + getNodeCount(root.left) + getNodeCount(root.right)
    }
}