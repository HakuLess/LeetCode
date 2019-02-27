package leetcode

import kotlin.collections.ArrayList

class Solution652 {
    val hashMap = hashMapOf<String, ArrayList<TreeNode>>()

    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        fillMap(root)
        val ans = hashSetOf<TreeNode>()
        hashMap.forEach { t, u ->
            println("$t $u")
            if (u.size > 1) {
                ans.add(u[0])
            }
        }
        return ans.toMutableList()
    }

    private fun fillMap(root: TreeNode?) {
        if (root == null) {
            return
        }
        val inOrder = inOrderTraversal(root).joinToString {
            it
        }

        hashMap[inOrder] = hashMap.getOrDefault(inOrder, arrayListOf())
        hashMap[inOrder]!!.add(root)

        fillMap(root.left)
        fillMap(root.right)

    }

    private fun inOrderTraversal(root: TreeNode?): ArrayList<String> {
        val result = arrayListOf<String>()
        if (root != null) {
            result.add(root.`val`.toString() + ",")
            result.addAll(inOrderTraversal(root.left) + ",")
            result.addAll(inOrderTraversal(root.right))
        } else {
            result.add("null")
        }
        return result
    }
}