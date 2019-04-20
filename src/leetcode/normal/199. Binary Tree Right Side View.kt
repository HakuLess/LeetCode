package leetcode.normal

import leetcode.TreeNode
import java.util.*

fun rightSideView(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }
    val ans = arrayListOf<Int>()
    val queue: Queue<TreeNode?> = LinkedList()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val size = queue.size
        var add = false
        for (i in 0 until size) {
            val item = queue.poll()
            if (item != null) {
                queue.add(item.right)
                queue.add(item.left)
                if (!add) {
                    ans.add(item.`val`)
                    add = true
                }
            }
        }
    }
    return ans
}