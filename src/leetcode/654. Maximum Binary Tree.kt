package leetcode

fun main(args: Array<String>) {
    val array = intArrayOf(3, 2, 1, 6, 0, 5)
    val tree = constructMaximumBinaryTree(array)
    println("----------------")
    tree?.print()
}

fun TreeNode.print() {
    printDFS(this)
}

fun printDFS(treeNode: TreeNode?) {
    if (treeNode == null) {
        return
    }
    println(treeNode.`val`)
    printDFS(treeNode.left)
    printDFS(treeNode.right)
}

// Definition for a binary tree node.
class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
    if (nums.isEmpty()) {
        return null
    }
    var max = -1
    var index = -1
    for (i in nums.indices) {
        if (nums[i] > max) {
            max = nums[i]
            index = i
        }
    }

    val curNode = TreeNode(max)
    val leftNums = IntArray(index)
    val rightNums = IntArray(nums.size - index - 1)

    for (i in nums.indices) {
        if (i < index) {
            leftNums[i] = nums[i]
        } else if (i > index){
            rightNums[i - index - 1] = nums[i]
        }
    }

    curNode.left = constructMaximumBinaryTree(leftNums)
    curNode.right = constructMaximumBinaryTree(rightNums)

    return curNode
}