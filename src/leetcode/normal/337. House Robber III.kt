package leetcode.normal

import leetcode.contest.utils.TreeNode
import kotlin.math.max

fun rob(root: TreeNode?): Int {

    return if (root == null) {
        0
    } else {
        max(root.`val` + rob(root.left?.left) + rob(root.left?.right) +
                rob(root.right?.left) + rob(root.right?.right), rob(root.left) + rob(root.right))
    }
}

