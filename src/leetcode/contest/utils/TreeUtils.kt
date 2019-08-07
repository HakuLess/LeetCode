package leetcode.contest.utils

import java.util.*

/**
 * 获取 TreeNode 的深度
 *
 * @return 自己为第1层，儿子2、孙子3，则自己的总深度是3
 * */
fun TreeNode?.depth(): Int = if (this == null) {
    0
} else {
    1 + maxOf(left.depth(), right.depth())
}

/**
 * 在 Tree 中查找值为 x 的 Node
 *
 * @param x 要查找的节点值
 * @return 值为 x 的Node，如果没有则返回null
 * */
fun TreeNode?.find(x: Int): TreeNode? = if (this == null) {
    null
} else {
    if (x == this.`val`) {
        this
    } else {
        this.left.find(x) ?: this.right.find(x)
    }
}

/**
 * 计算树的总节点数（包括自己）
 *
 * @return 总Node数
 * */
fun TreeNode?.count(): Int = if (this == null) {
    0
} else {
    1 + this.left.count() + this.right.count()
}

fun <T> Array<T>.toTree(): TreeNode? {
    if (this.isEmpty()) {
        return null
    }
    val queue: Queue<TreeNode> = LinkedList()
    var index = 0
    val root = TreeNode(this[index] as Int)
    queue.add(root)
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val node = queue.poll()
            index++
            if (index <= this.lastIndex && this[index] is Int) {
                node.left = TreeNode(this[index] as Int)
                queue.offer(node.left)
            }
            index++
            if (index <= this.lastIndex && this[index] is Int) {
                node.right = TreeNode(this[index] as Int)
                queue.offer(node.right)
            }
        }
    }

    return root
}