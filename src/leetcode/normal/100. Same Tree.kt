package leetcode.normal

import leetcode.contest.utils.TreeNode

/**
 * Created by HaKu on 21/03/2018.
 */

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

fun main(args: Array<String>) {
    val a = TreeNode(1)
    val b = TreeNode(2)
    val c = TreeNode(3)

    a.left = b
    b.left = c

    val a1 = TreeNode(1)
    val b1 = TreeNode(2)
    val c1 = TreeNode(3)
    a1.left = c1
    b1.left = b1

    isSameTree(a, a1)
    if (isSameTree(a, a1)) {
        println("true")
    } else {
        println("false")
    }
}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    return if (p == null && q == null) {
        true
    } else if (p != null && q != null && p.`val` == q.`val`) {
        (isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
    } else {
        false
    }
}