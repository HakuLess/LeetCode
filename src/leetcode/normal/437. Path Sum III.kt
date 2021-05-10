package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution437 {
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        if (root == null)
            return 0
        fun pathSumSub(root: TreeNode?, sum: Int): Int {
            if (root == null)
                return 0
            return pathSumSub(root.left, sum - root.`val`) + pathSumSub(root.right, sum - root.`val`) +
                    if (sum == root.`val`) 1 else 0
        }
        return pathSumSub(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum)
    }
}