package leetcode

fun averageOfLevels(root: TreeNode?): DoubleArray {

    val list = arrayListOf<ArrayList<Int>>()
    fillList(root, 0, list)

    val result = DoubleArray(list.size)
    list.forEachIndexed { index, arrayList ->
        var sum = 0L
        arrayList.forEach {
            sum += it
        }
        result[index] = sum.toDouble() / arrayList.size
    }
    return result
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