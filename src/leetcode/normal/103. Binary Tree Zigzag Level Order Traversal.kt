package leetcode.normal

import leetcode.contest.utils.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class Solution103 {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }
        val result = arrayListOf<List<Int>>()
        val queue: Queue<TreeNode?> = LinkedList()
        queue.add(root)
        var left = false
        while (queue.isNotEmpty()) {
            left = !left
            val size = queue.size
            val array = ArrayList<Int>()
            for (i in 0 until size) {
                val item = queue.poll()
                item?.let {
                    array.add(item.`val`)
                    queue.offer(item.left)
                    queue.offer(item.right)
                }
            }
            if (array.isNotEmpty()) {
                result.add(if (left) {
                    array
                } else {
                    array.reversed()
                })
            }
        }
        return result
    }
}