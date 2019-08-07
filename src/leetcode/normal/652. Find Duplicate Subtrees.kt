package leetcode.normal

import leetcode.contest.utils.TreeNode

class Solution652 {
    private val signatureToTreeNode = mutableMapOf<String, MutableSet<TreeNode>>()

    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        encodeTree(root)
        return signatureToTreeNode.filterValues {
            it.size > 1
        }.mapValues {
            it.value.first()
        }.values.toList()
    }

    fun encodeTree(p: TreeNode?): String {
        if (p == null) {
            return "null"
        }
        val encoded = "${p.`val`}(${encodeTree(p.left)}, ${encodeTree(p.right)})"
        signatureToTreeNode.getOrPut(encoded) {
            mutableSetOf()
        }.add(p)
        return encoded
    }
}