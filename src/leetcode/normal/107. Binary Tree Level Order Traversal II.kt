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
    levelOrderBottom(root).print()
}

fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    val result = arrayListOf<ArrayList<Int>>()
    fillList(root, 0, result)
    result.reverse()
    return result
}

fun fillList(root: TreeNode?, level: Int, result: ArrayList<ArrayList<Int>>) {
    if (root == null) {
        return
    }
    val orderLevel = result.getOrElse(level) {
        result.add(it, arrayListOf())
        result[it]
    }
    orderLevel.add(root.`val`)

    fillList(root.left, level + 1, result)
    fillList(root.right, level + 1, result)
}