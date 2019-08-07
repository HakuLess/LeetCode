package leetcode.normal

import leetcode.contest.utils.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class Solution102 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }

        val result = arrayListOf<ArrayList<Int>>()
        val queue: Queue<TreeNode?> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val size = queue.size
            val array = ArrayList<Int>()
            for (i in 0 until size) {
                val item = queue.poll()
                if (item == null) {
                    continue
                } else {
                    array.add(item.`val`)
                    if (item.left != null) {
                        queue.offer(item.left)
                    }
                    if (item.right != null) {
                        queue.offer(item.right)
                    }
                }
            }
            result.add(array)
        }
        return result
    }

}