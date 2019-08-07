package leetcode.learn

import leetcode.contest.utils.TreeNode

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty()) {
        return null
    }

    return buildSubTree(preorder, inorder, 0, preorder.size - 1, 0)
}

fun buildSubTree(preorder: IntArray, inorder: IntArray, start: Int, end: Int, preIndex: Int): TreeNode? {
    if (start > preorder.size - 1 || start > end) {
        return null
    }
    val root = TreeNode(preorder[preIndex])
    val mid = inorder.indexOf(preorder[preIndex])
    root.left = buildSubTree(preorder, inorder, start, mid - 1, preIndex + 1)
    root.right = buildSubTree(preorder, inorder, mid + 1, end, preIndex + mid - start + 1)
    return root
}