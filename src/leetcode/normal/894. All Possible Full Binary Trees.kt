package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution894 {
    val map = hashMapOf<Int, List<TreeNode>>()
    fun allPossibleFBT(N: Int): List<TreeNode?> {
        if (map.containsKey(N)) {
            return map[N]!!
        }
        val ans = arrayListOf<TreeNode>()
        if (N == 1) {
            ans.add(TreeNode(0))
        } else {
            for (x in 1 until N step 2) {
                val y = N - 1 - x
                for (left in allPossibleFBT(x)) {
                    for (right in allPossibleFBT(y)) {
                        val root = TreeNode(0)
                        root.left = left
                        root.right = right
                        ans.add(root)
                    }
                }
            }
        }
        map[N] = ans
        return map[N]!!
    }
}