package leetcode.normal

import leetcode.contest.utils.TreeNode


class Solution508 {
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        val map = hashMapOf<Int, Int>()
        fun dfs(root: TreeNode?): Int {
            if (root == null) {
                return 0
            }
            val key = dfs(root.left) + root.`val` + dfs(root.right)
            map[key] = map.getOrDefault(key, 0) + 1
            return key
        }
        dfs(root)
        val max = map.maxBy { it.value }?.value
        return map.filter { it.value == max }.map {
            it.key
        }.toIntArray()
    }
}