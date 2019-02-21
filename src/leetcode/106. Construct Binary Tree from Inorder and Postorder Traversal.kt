package leetcode

class Solution106 {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        if (inorder.isEmpty()) {
            return null
        }

        val rootValue = postorder.last()

        val inOrderLeftSub = arrayListOf<Int>()
        val inOrderRightSub = arrayListOf<Int>()
        var before = true
        inorder.forEach {
            when {
                it == rootValue -> before = false
                before -> inOrderLeftSub.add(it)
                else -> inOrderRightSub.add(it)
            }
        }

        val postOrderLeftSub = arrayListOf<Int>()
        val postOrderRightSub = arrayListOf<Int>()
        for (i in 0 until inOrderLeftSub.size) {
            postOrderLeftSub.add(postorder[i])
        }
        for (j in 0 until inOrderRightSub.size) {
            postOrderRightSub.add(postorder[inOrderLeftSub.size + j])
        }

        val root = TreeNode(rootValue)
        if (inOrderLeftSub.isNotEmpty()) {
            root.left = buildTree(inOrderLeftSub.toIntArray(), postOrderLeftSub.toIntArray())
        }
        if (inOrderRightSub.isNotEmpty()) {
            root.right = buildTree(inOrderRightSub.toIntArray(), postOrderRightSub.toIntArray())
        }

        return root
    }
}