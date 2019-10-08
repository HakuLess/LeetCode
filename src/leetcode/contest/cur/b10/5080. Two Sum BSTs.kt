package leetcode.contest.cur.b10

import leetcode.contest.utils.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class Solution5080 {
    fun twoSumBSTs(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
        val l1 = tree2List(root1)
        val l2 = tree2List(root2)
        l1.forEach {
            if ((target - it) in l2) {
                return true
            }
        }
        return false
    }

    private fun tree2List(root: TreeNode?): ArrayList<Int> {
        val ans = arrayListOf<Int>()
        if (root == null) {
            return ans
        }
        val queue: Queue<TreeNode?> = LinkedList<TreeNode?>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item != null) {
                    ans.add(item.`val`)
                    queue.offer(item.left)
                    queue.offer(item.right)
                }
            }
        }
        return ans
    }
}