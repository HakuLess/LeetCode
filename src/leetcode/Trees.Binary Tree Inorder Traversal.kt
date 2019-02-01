package leetcode


fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = arrayListOf<Int>()
    if (root != null) {
        result.addAll(inorderTraversal(root.left))
        result.add(root.`val`)
        result.addAll(inorderTraversal(root.right))
    }
    return result
}