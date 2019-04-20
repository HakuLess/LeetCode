package leetcode.normal

import leetcode.TreeNode

class Solution113 {

    val ans = arrayListOf<ArrayList<Int>>()

    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        fillAns(root, sum, arrayListOf())
        return ans
    }

    fun fillAns(root: TreeNode?, sum: Int, list: ArrayList<Int>) {
        if (root == null) {
            return
        }
        val temp = ArrayList(list)
        temp.add(root.`val`)
        if (root.left == null && root.right == null && sum == root.`val`) {
            ans.add(temp)
        } else {
            fillAns(root.left, sum - root.`val`, temp)
            fillAns(root.right, sum - root.`val`, temp)
        }
    }
}