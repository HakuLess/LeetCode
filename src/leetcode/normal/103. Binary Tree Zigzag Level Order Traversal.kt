package leetcode.normal

import leetcode.contest.utils.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class Solution103 {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }

        val result = arrayListOf<ArrayList<Int>>()
        val queue: Queue<TreeNode?> = LinkedList()
        queue.add(root)

        var step = 0
        while (queue.isNotEmpty()) {
            step++
            val size = queue.size
            val array = ArrayList<Int>()
            for (i in 0 until size) {
                val item = queue.poll()
                if (item == null) {
                    continue
                } else {
                    array.add(item.`val`)
                    queue.offer(item.left)
                    queue.offer(item.right)
                }
            }
            if (array.isNotEmpty()) {
                result.add(if (step % 2 != 0) {
                    array
                } else {
                    array.reverse()
                    array
                })
            }
        }
        return result
    }
}