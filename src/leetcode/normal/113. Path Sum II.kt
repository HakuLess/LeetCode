package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution113 {
    val ans = arrayListOf<ArrayList<Int>>()

    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        helper(root, sum, arrayListOf())
        return ans
    }

    private fun helper(root: TreeNode?, sum: Int, list: ArrayList<Int>) {
        if (root == null) {
            return
        }
        val temp = ArrayList(list)
        temp.add(root.`val`)
        if (root.left == null && root.right == null && sum == root.`val`) {
            ans.add(temp)
        } else {
            helper(root.left, sum - root.`val`, temp)
            helper(root.right, sum - root.`val`, temp)
        }
    }
}