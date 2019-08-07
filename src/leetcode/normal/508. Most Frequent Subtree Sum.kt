package leetcode.normal

import leetcode.contest.utils.TreeNode


class Solution508 {
    val map = hashMapOf<Int, Int>()

    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        fill(root)
        var max = Int.MIN_VALUE
        val ans = arrayListOf<Int>()
        map.forEach { t, u ->
            if (u > max) {
                max = u
                ans.clear()
                ans.add(t)
            } else if (u == max) {
                ans.add(t)
            }
        }
        return ans.toIntArray()
    }

    private fun fill(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val key = fill(root.left) + root.`val` + fill(root.right)
        map[key] = map.getOrDefault(key, 0) + 1
        return key
    }
}