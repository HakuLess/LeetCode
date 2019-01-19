package leetcode

fun main(args: Array<String>) {

}


fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
    var root: TreeNode? = null

    if (t1 == null && t2 == null) {
        return null
    } else {
        when {
            t1 == null -> return t2
            t2 == null -> return t1
        }
    }

    root = TreeNode(t1!!.`val` + t2!!.`val`)
    root.left = mergeTrees(t1.left, t2.left)
    root.right = mergeTrees(t1.right, t2.right)
    return root
}