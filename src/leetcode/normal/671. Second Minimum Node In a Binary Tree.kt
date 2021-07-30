package leetcode.normal

import leetcode.contest.utils.TreeNode
import java.util.*

class Solution671 {
    fun findSecondMinimumValue(root: TreeNode?): Int {
        val queue: Queue<TreeNode?> = LinkedList()
        queue.add(root)
        var ans = Pair(Long.MAX_VALUE, Long.MAX_VALUE)

        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item == null) {
                    continue
                } else {
                    queue.add(item.left)
                    queue.add(item.right)
                    if (item.`val`.toLong() == ans.first || item.`val`.toLong() == ans.second) {
                        continue
                    }
                    if (item.`val` < ans.first) {
                        ans = Pair(item.`val`.toLong(), ans.first)
                    } else if (item.`val` < ans.second) {
                        ans = Pair(ans.first, item.`val`.toLong())
                    }
                }
            }
        }
        return if (ans.second == Long.MAX_VALUE) {
            -1
        } else {
            ans.second.toInt()
        }
    }
}