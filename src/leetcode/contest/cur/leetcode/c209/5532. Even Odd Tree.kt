package leetcode.contest.cur.leetcode.c209

import leetcode.contest.utils.TreeNode

class Solution5532 {
    fun isEvenOddTree(root: TreeNode?): Boolean {
        val map = HashMap<Int, ArrayList<Int>>()
        fun dfs(node: TreeNode?, level: Int) {
            if (node == null) return
            map[level] = map.getOrDefault(level, arrayListOf())
            map[level]!!.add(node.`val`)
            dfs(node.left, level + 1)
            dfs(node.right, level + 1)
        }
        dfs(root, 0)
        var ans = true
        map.forEach { (i, l) ->
            if (i % 2 == 0) {
                println("$i: ${l.joinToString()}")
                if (l.joinToString() != l.distinct().sorted().joinToString() || l.any { it % 2 == 0 }) {
                    ans = false
                    return@forEach
                }
            } else {
                if (l.joinToString() != l.distinct().sortedDescending().joinToString() || l.any { it % 2 != 0 }) {
                    ans = false
                    return@forEach
                }
            }
        }
        return ans
    }
}