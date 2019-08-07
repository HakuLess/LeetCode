package leetcode.normal

import leetcode.contest.utils.TreeNode

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    if (root == null) {
        return null
    }

    return if (root.`val` == `val`) {
        root
    } else if (root.`val` > `val`) {
        searchBST(root.left, `val`)
    } else {
        searchBST(root.right, `val`)
    }
}