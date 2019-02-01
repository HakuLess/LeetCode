package leetcode

fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    val result = arrayListOf<ArrayList<Int>>()
    dfs(root, 0, result)
    result.forEachIndexed { index, arrayList ->
        if (index % 2 != 0) {
            arrayList.reverse()
        }
    }
    return result
}