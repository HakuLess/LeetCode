package leetcode.learn

import leetcode.TreeNode

fun main(args: Array<String>) {

}

fun isSymmetric(root: TreeNode?): Boolean {

    return if (root != null) {
        isSubSymmetric(root.left, root.right)
    } else {
        true
    }
}

fun isSubSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
    when {
        left == null && right == null -> {
            return true
        }
        left == null && right != null -> {
            return false
        }
        left != null && right == null -> {
            return false
        }
        else -> {
            return if (left!!.`val` == right!!.`val`) {
                isSubSymmetric(left.left, right.right) && isSubSymmetric(left.right, right.left)
            } else {
                false
            }
        }
    }
}