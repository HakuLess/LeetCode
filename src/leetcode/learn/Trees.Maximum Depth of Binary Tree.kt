package leetcode.learn

import leetcode.TreeNode
import kotlin.math.max

fun main(args: Array<String>) {

}

fun maxDepth(root: TreeNode?): Int {
    return maxDepth(root, 0)
}

fun maxDepth(root: TreeNode?, level: Int): Int {
    return if (root == null) {
        level
    } else {
        max(maxDepth(root.left, level + 1), maxDepth(root.right, level + 1))
    }
}