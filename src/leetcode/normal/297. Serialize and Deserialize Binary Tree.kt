package leetcode.normal

import leetcode.contest.utils.TreeNode
import leetcode.contest.utils.print
import java.util.*

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

fun main(args: Array<String>) {
    val s = Codec()
    val root = s.deserialize("1,2,3,null,null,4,5")
    root?.print()
    s.serialize(null).print()
}

class Codec() {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null) {
            return ""
        }
        val ans = arrayListOf<String?>()
        val queue: Queue<TreeNode?> = LinkedList<TreeNode?>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                ans.add(item?.`val`?.toString())
                if (item != null) {
                    queue.offer(item.left)
                    queue.offer(item.right)
                }
            }
        }
        return ans.joinToString(",")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) {
            return null
        }
        val items = data.split(",")
        val queue: Queue<TreeNode?> = LinkedList<TreeNode?>()
        val root = TreeNode(items[0].toInt())
        queue.add(root)
        var index = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                item?.`val`?.print()
                if (item != null) {
                    index++
                    val nl = if (index !in items.indices || items[index] == "null") {
                        null
                    } else
                        TreeNode(items[index].toInt())
                    index++
                    val nr = if (index !in items.indices || items[index] == "null") {
                        null
                    } else
                        TreeNode(items[index].toInt())
                    item.left = nl
                    item.right = nr
                    queue.add(nl)
                    queue.add(nr)
                }
            }
        }
        return root
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var obj = Codec()
 * var data = obj.encode(longUrl)
 * var ans = obj.decode(data)
 */