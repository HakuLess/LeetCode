package leetcode

class Solution530 {

    var min = Int.MAX_VALUE

    fun getMinimumDifference(root: TreeNode?): Int {
        getMin(root)
        return min
    }

    private fun getMin(root: TreeNode?) {
        if (root == null) {
            return
        }
        if (root.left != null) {
            var temp = root.left!!
            while (temp.right != null) {
                temp = temp.right!!
            }
            val less = temp.`val`
            min = minOf(min, root.`val` - less)
        }

        if (root.right != null) {
            var temp = root.right!!
            while (temp.left != null) {
                temp = temp.left!!
            }
            val more = temp.`val`
            min = minOf(min, more - root.`val`)
        }

        getMin(root.left)
        getMin(root.right)
    }
}