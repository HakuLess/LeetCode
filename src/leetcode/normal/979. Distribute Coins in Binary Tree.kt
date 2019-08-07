package leetcode.normal

import leetcode.contest.utils.TreeNode
import kotlin.math.abs

class Solution979 {

    var sum = 0
    fun distributeCoins(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        postOrder(root)
        return sum
    }

    private fun postOrder(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        var cur = 0
        val left = postOrder(root.left)
        val right = postOrder(root.right)

        if (root.left != null) {
            sum += abs(left)
            cur += left
        }
        if (root.right != null) {
            sum += abs(right)
            cur += right
        }

        cur += root.`val` - 1
        return cur
    }
}