package leetcode.contest.last.c190

import leetcode.contest.utils.TreeNode

class Solution5418 {
    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        return dfs(root, hashMapOf())
    }

    private fun dfs(node: TreeNode?, map: HashMap<Int, Int>): Int {
        if (node == null) {
            return 0
        }
        map[node.`val`] = map.getOrDefault(node.`val`, 0) + 1

        if (node.left == null && node.right == null) {
            var odd = 0
            for (k in map) {
                if (k.value % 2 == 1) {
                    odd += 1
                }
            }
            return if (odd > 1) {
                0
            } else {
                1
            }
        } else {
            var ans = 0
            ans += dfs(node.left, HashMap(map))
            ans += dfs(node.right, HashMap(map))
            return ans
        }
    }
}