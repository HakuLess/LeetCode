package leetcode.contest.cur.c150

import leetcode.contest.utils.TreeNode
import java.util.*

class Solution5052 {
    fun maxLevelSum(root: TreeNode?): Int {
        val queue: Queue<TreeNode?> = LinkedList<TreeNode?>()
        queue.add(root)
        var ans = Int.MIN_VALUE
        var step = 0
        var res = 0
        while (queue.isNotEmpty()) {
            var sum = 0
            step++
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item != null) {
                    sum += item.`val`
                    queue.offer(item.left)
                    queue.offer(item.right)
                }
            }
            if (sum > ans) {
                res = step
                ans = sum
            }
        }
        return res
    }
}