package leetcode.normal

import leetcode.TreeNode
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class Solution863 {
    private val parent = HashMap<TreeNode, TreeNode?>()

    fun distanceK(root: TreeNode?, target: TreeNode?, K: Int): List<Int> {
        if (root == null || target == null) {
            return emptyList()
        }

        initParent(root, null)

        val ans = arrayListOf<Int>()
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.add(target)
        val seen = HashSet<TreeNode>()
        seen.add(target)
        var t = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            t++
            if (t == K + 1) {
                while (queue.isNotEmpty()) {
                    ans.add(queue.poll().`val`)
                }
                return ans
            } else {
                for (i in 0 until size) {
                    val item = queue.poll()
                    if (item.left != null && !seen.contains(item.left!!)) {
                        queue.offer(item.left!!)
                        seen.add(item.left!!)
                    }
                    if (item.right != null && !seen.contains(item.right!!)) {
                        queue.offer(item.right!!)
                        seen.add(item.right!!)
                    }
                    if (parent[item] != null && !seen.contains(parent[item]!!)) {
                        queue.offer(parent[item])
                        seen.add(parent[item]!!)
                    }
                }
            }
        }

        return ans
    }

    private fun initParent(node: TreeNode?, par: TreeNode?) {
        if (node != null) {
            parent[node] = par
            initParent(node.left, node)
            initParent(node.right, node)
        }
    }
}

