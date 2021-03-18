package leetcode.normal

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution589 {
    val ans = arrayListOf<Int>()
    fun preorder(root: Node?): List<Int> {
        if (root == null) return ans
        ans.add(root.`val`)
        root.neighbors.forEach {
            preorder(it)
        }
        return ans
    }
}