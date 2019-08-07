package leetcode.normal

import leetcode.contest.utils.TreeNode
import leetcode.learn.maxDepth

fun diameterOfBinaryTree(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    return maxOf(maxDepth(root.left) + maxDepth(root.right),
            diameterOfBinaryTree(root.left),
            diameterOfBinaryTree(root.right))
}

//fun maxDepth(root: TreeNode?): Int {
//    return maxDepth(root, 0)
//}
//
//fun maxDepth(root: TreeNode?, level: Int): Int {
//    return if (root == null) {
//        level
//    } else {
//        max(maxDepth(root.left, level + 1), maxDepth(root.right, level + 1))
//    }
//}