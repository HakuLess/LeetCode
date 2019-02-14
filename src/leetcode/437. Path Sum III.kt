package leetcode

fun main(args: Array<String>) {
    val r1 = TreeNode(0)
    val r2 = TreeNode(1)
    val r3 = TreeNode(1)
    r1.left = r2
    r1.right = r3
    pathSum(r1, 1).print()
}

fun pathSum(root: TreeNode?, sum: Int): Int {
    if (root == null) {
        return 0
    }
    return pathSumSub(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum)
}

fun pathSumSub(root: TreeNode?, sum: Int): Int {
    if (root == null) {
        return 0
    }

    return if (sum == root.`val`) {
        1
    } else {
        0
    } + pathSumSub(root.left, sum - root.`val`) + pathSumSub(root.right, sum - root.`val`)
}