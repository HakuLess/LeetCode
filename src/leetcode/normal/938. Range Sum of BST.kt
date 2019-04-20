package leetcode.normal

import leetcode.TreeNode

fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
    if (root == null) {
        return 0
    }
    return if (root.`val` in L..R) {
        root.`val` + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R)
    } else {
        rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R)
    }
}