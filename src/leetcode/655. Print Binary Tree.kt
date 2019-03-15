package leetcode

class Solution655 {
    fun printTree(root: TreeNode?): List<List<String>> {
        val depth = maxDepth(root)
        var max = 1
        for (i in 0 until depth - 1) {
            max = max * 2 + 1
        }
        print(max)
        val ans = Array(depth) { Array(max) { "" } }
        dfs(ans, 0, 0, max, root)
        val res = arrayListOf<List<String>>()
        for (list in ans) {
            res.add(list.toList())
        }
        return res
    }

    private fun dfs(matrix: Array<Array<String>>, level: Int, left: Int, right: Int, node: TreeNode?) {
        if (node == null) {
            return
        }
        val mid = left + (right - left) / 2
        println("$level $mid ${node.`val`} : $left $right")
        matrix[level][mid] = node.`val`.toString()

        dfs(matrix, level + 1, left, mid - 1, node.left)
        dfs(matrix, level + 1, mid + 1, right, node.right)
    }

    private fun maxDepth(root: TreeNode?): Int {
        return maxDepth(root, 0)
    }

    private fun maxDepth(root: TreeNode?, level: Int): Int {
        return if (root == null) {
            level
        } else {
            maxOf(maxDepth(root.left, level + 1), maxDepth(root.right, level + 1))
        }
    }
}