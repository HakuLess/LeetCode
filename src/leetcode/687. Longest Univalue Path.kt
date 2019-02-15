package leetcode

import kotlin.math.max

var ans1 = 0

fun longestUnivaluePath(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    longestUnivalue(root)
    return ans1
}

fun longestUnivalue(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    val left = longestUnivalue(root.left)
    val right = longestUnivalue(root.right)

    var arrowLeft = 0
    var arrowRight = 0
    if (root.left != null && root.left!!.`val` == root.`val`) {
        arrowLeft += left + 1
    }
    if (root.right != null && root.right!!.`val` == root.`val`) {
        arrowRight += right + 1
    }
    ans1 = max(ans1, arrowLeft + arrowRight)
    return max(arrowLeft, arrowRight)
}