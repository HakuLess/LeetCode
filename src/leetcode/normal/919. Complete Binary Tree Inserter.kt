package leetcode.normal

import leetcode.contest.utils.TreeNode
import leetcode.contest.utils.print
import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class CBTInserter(val root: TreeNode) {

    val list = arrayListOf<TreeNode>()

    init {
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                println("${item.`val`} : ${item.left?.`val`}, ${item.right?.`val`}")
                if (item.left == null || item.right == null) list.add(item)
                if (item.left != null) queue.offer(item.left)
                if (item.right != null) queue.offer(item.right)
            }
        }
    }

    fun insert(v: Int): Int {
        println(list.joinToString { it.`val`.toString() })

        val ans = list[0].`val`
        if (list[0].left == null) {
            list[0].left = TreeNode(v)
            list.add(list[0].left!!)
        } else {
            list[0].right = TreeNode(v)
            list.add(list[0].right!!)
            list.removeAt(0)
        }
        return ans
    }

    fun get_root(): TreeNode? {
        return root
    }

}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * var obj = CBTInserter(root)
 * var param_1 = obj.insert(v)
 * var param_2 = obj.get_root()
 */