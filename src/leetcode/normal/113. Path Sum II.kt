package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution113 {

    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        val ans = arrayListOf<ArrayList<Int>>()
        fun dfs(root: TreeNode?, sum: Int, list: ArrayList<Int>) {
            if (root == null) {
                return
            }
            val temp = ArrayList(list)
            temp.add(root.`val`)
            if (root.left == null && root.right == null && sum == root.`val`) {
                ans.add(temp)
            } else {
                dfs(root.left, sum - root.`val`, temp)
                dfs(root.right, sum - root.`val`, temp)
            }
        }
        dfs(root, sum, arrayListOf())
        return ans
    }
}