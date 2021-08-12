package leetcode.normal

import leetcode.contest.utils.TreeNode
import java.util.*

class Solution501 {
    fun findMode(root: TreeNode?): IntArray {
        if (root == null) {
            return intArrayOf()
        }

        val map = hashMapOf<Int, Int>()
        val queue: Queue<TreeNode?> = LinkedList<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll() ?: continue
                map[item.`val`] = map.getOrDefault(item.`val`, 0) + 1
                queue.add(item.left)
                queue.add(item.right)
            }
        }
        val max = map.values.maxOrNull()!!
        val ans = arrayListOf<Int>()
        map.forEach { (t, u) ->
            if (max == u) {
                ans.add(t)
            }
        }
        return ans.toIntArray()
    }
}