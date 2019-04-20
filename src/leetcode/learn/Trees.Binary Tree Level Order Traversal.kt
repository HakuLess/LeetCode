package leetcode.learn

import leetcode.TreeNode

fun main(args: Array<String>) {

}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val result = arrayListOf<ArrayList<Int>>()
    dfs(root, 0, result)
    return result
}

fun dfs(root: TreeNode?, level: Int, result: ArrayList<ArrayList<Int>>) {
    if (root == null) {
        return
    }

    if (result.size <= level) {
        result.add(arrayListOf())
    }
    result[level].add(root.`val`)
    dfs(root.left, level + 1, result)
    dfs(root.right, level + 1, result)
}