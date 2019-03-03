package leetcode

import java.util.*

class Solution987 {

    val map = TreeMap<Int, ArrayList<Pair<Int, Int>>>()

    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        dfs(root, 0, 0)
        val ans = arrayListOf<List<Int>>()
        map.forEach { _, u ->
            u.sortWith(
                    compareBy({ it.first }, { it.second })
            )
            ans.add(u.map {
                it.second
            })
        }
        return ans
    }

    private fun dfs(root: TreeNode?, p: Int, level: Int) {
        if (root == null) {
            return
        }
        val list = map.getOrPut(p) { arrayListOf() }
        list.add(Pair(level, root.`val`))
        dfs(root.left, p - 1, level + 1)
        dfs(root.right, p + 1, level + 1)
    }
}