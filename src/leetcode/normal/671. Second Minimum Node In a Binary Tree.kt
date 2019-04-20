package leetcode.normal

import leetcode.TreeNode
import java.util.*

class Solution671 {
    fun findSecondMinimumValue(root: TreeNode?): Int {
        val queue: Queue<TreeNode?> = LinkedList()
        queue.add(root)
        var ans = Pair(Int.MAX_VALUE, Int.MAX_VALUE)

        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item == null) {
                    continue
                } else {
                    queue.add(item.left)
                    queue.add(item.right)
                    if (item.`val` == ans.first || item.`val` == ans.second) {
                        continue
                    }
                    if (item.`val` < ans.first) {
                        ans = Pair(item.`val`, ans.first)
                    } else if (item.`val` < ans.second) {
                        ans = Pair(ans.first, item.`val`)
                    }
                }
            }
        }
        return if (ans.second == Int.MAX_VALUE) {
            -1
        } else {
            ans.second
        }
    }
}