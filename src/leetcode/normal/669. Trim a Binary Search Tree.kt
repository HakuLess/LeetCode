package leetcode.normal

import leetcode.contest.utils.TreeNode

fun trimBST(root: TreeNode?, L: Int, R: Int): TreeNode? {
    if (root == null) {
        return null
    }
    var ans = root
    when {
        root.`val` < L -> ans = trimBST(ans.right, L, R)
        root.`val` > R -> ans = trimBST(ans.left, L, R)
        else -> {
            ans.left = trimBST(ans.left, L, R)
            ans.right = trimBST(ans.right, L, R)
        }
    }
    return ans
}