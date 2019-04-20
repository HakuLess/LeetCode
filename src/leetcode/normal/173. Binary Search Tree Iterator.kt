package leetcode.normal

import leetcode.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class BSTIterator(root: TreeNode?) {

    var list = arrayListOf<Int>()
    var index = -1

    init {
        list = inorderTraversal(root)
    }

    /** @return the next smallest number */
    fun next(): Int {
        index++
        return list[index]
    }

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean {
        return index + 1 < list.size
    }

    fun inorderTraversal(root: TreeNode?): ArrayList<Int> {
        if (root == null) {
            return arrayListOf()
        }
        val result = arrayListOf<Int>()
        val stack = Stack<TreeNode?>()
        var item = root
        while (item != null || stack.isNotEmpty()) {
            while (item != null) {
                stack.push(item)
                item = item.left
            }
            item = stack.pop()
            result.add(item!!.`val`)
            item = item.right
        }

        return result
    }
}