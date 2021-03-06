package leetcode.normal

import leetcode.contest.utils.TreeNode
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val root = TreeNode(3)
    val l1 = TreeNode(9)
    val l2 = TreeNode(20)
    val r1 = TreeNode(15)
    val r2 = TreeNode(7)

    root.left = l1
    root.right = l2
    l2.left = r1
    l2.right = r2

    val s = Solution107()
    s.levelOrderBottom(root).print()
}

class Solution107 {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val result = arrayListOf<ArrayList<Int>>()
        fun fillList(root: TreeNode?, level: Int) {
            if (root == null) {
                return
            }
            val orderLevel = result.getOrElse(level) {
                result.add(it, arrayListOf())
                result[it]
            }
            orderLevel.add(root.`val`)
            fillList(root.left, level + 1)
            fillList(root.right, level + 1)
        }
        fillList(root, 0)
        result.reverse()
        return result
    }
}