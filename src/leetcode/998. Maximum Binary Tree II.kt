package leetcode

import java.util.*
import kotlin.collections.ArrayList

fun insertIntoMaxTree(root: TreeNode?, `val`: Int): TreeNode? {
    val source = inorderTraversal(root)
    source.add(`val`)
    return constructMaximumBinaryTree(source.toIntArray())
}

fun inorderTraversal(root: TreeNode?): ArrayList<Int> {
    val result = arrayListOf<Int>()
    if (root != null) {
        result.addAll(inorderTraversal(root.left))
        result.add(root.`val`)
        result.addAll(inorderTraversal(root.right))
    }
    return result
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