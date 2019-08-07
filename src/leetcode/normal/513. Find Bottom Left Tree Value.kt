package leetcode.normal

import leetcode.contest.utils.TreeNode

fun findBottomLeftValue(root: TreeNode?): Int {
    val list = arrayListOf<ArrayList<Int>>()
    fillList(root, 0, list)
    return list.last().first()
}

//fun fillList(root: TreeNode?, level: Int, result: ArrayList<ArrayList<Int>>) {
//    if (root == null) {
//        return
//    }
//    val orderLevel = result.getOrElse(level) {
//        result.add(it, arrayListOf())
//        result[it]
//    }
//    orderLevel.add(root.`val`)
//
//    fillList(root.left, level + 1, result)
//    fillList(root.right, level + 1, result)
//}