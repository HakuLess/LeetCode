package leetcode.normal

import leetcode.contest.utils.TreeNode

/**
 * Created by HaKu on 2018/6/2.
 */

class Solution404 {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        fun dfs(root: TreeNode?, isLeft: Boolean): Int {
            if (root == null) {
                return 0
            }
            var sum = 0
            if (isLeft && root.left == null && root.right == null) {
                sum += root.`val`
            }
            if (root.left != null) {
                sum += dfs(root.left, true)
            }
            if (root.right != null) {
                sum += dfs(root.right, false)
            }
            return sum
        }
        return dfs(root, false)
    }
}