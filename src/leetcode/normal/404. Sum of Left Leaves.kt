package leetcode.normal

import leetcode.contest.utils.TreeNode

/**
 * Created by HaKu on 2018/6/2.
 */

fun main(args: Array<String>) {
    val a = TreeNode(3)
//    val b = TreeNode(9)
//    val c = TreeNode(20)
//    val d = TreeNode(15)
//    val e = TreeNode(7)
//
//    a.left = b
//    a.right = c
//    c.left = d
//    c.right = e

    println(sumOfLeftLeaves(a))
}

fun sumOfLeftLeaves(root: TreeNode?): Int {
    return getSum(root, false)
}

fun getSum(root: TreeNode?, isLeft: Boolean): Int {
    if (root == null) {
        return 0
    }
    var sum = 0
    if (isLeft && root.left == null && root.right == null) {
        sum += root.`val`
    }
    if (root.left != null) {
        sum += getSum(root.left, true)
    }
    if (root.right != null) {
        sum += getSum(root.right, false)
    }
    return sum
}