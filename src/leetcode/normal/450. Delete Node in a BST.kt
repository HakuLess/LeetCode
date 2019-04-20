package leetcode.normal

import leetcode.TreeNode

fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
    if (root == null) {
        return null
    }
    if (root.`val` == key) {
        if (root.left == null && root.right == null) {
            return null
        } else if (root.left != null && root.right == null) {
            return root.left
        } else if (root.right != null && root.left == null) {
            return root.right
        } else {
            // in-order successor node
            var pre = root.right!!
            var prePre: TreeNode? = null
            while (pre.left != null) {
                prePre = pre
                pre = pre.left!!
            }

            return if (prePre == null) {
                pre.left = root.left
                pre
            } else {
                prePre.left = pre.right
                root.`val` = pre.`val`
                root
            }
        }
    } else {
        root.left = deleteNode(root.left, key)
        root.right = deleteNode(root.right, key)
    }

    return root
}