package leetcode.contest.cur.c148

import leetcode.TreeNode

class Solution1146 {
    fun btreeGameWinningMove(root: TreeNode?, n: Int, x: Int): Boolean {
        val node = findChildRoot(root, x)!!
        var left = 0
        var right = 0
        if (node.left != null) {
            left = findChild(root, node.left!!.`val`)
        }
        if (node.right != null) {
            right = findChild(root, node.right!!.`val`)
        }

        println("$left , $right, $n")
        return if (left > n - left || right > n - right) {
            true
        } else n - left - right > n / 2
    }

    private fun findChildRoot(root: TreeNode?, x: Int): TreeNode? {
        if (root == null) {
            return null
        }
        if (root.`val` == x) {
            return root
        } else {
            val a = findChildRoot(root.left, x)
            val b = findChildRoot(root.right, x)
            if (a != null) {
                return a
            }
            if (b != null) {
                return b
            }
            return null
        }
    }

    private fun findChild(root: TreeNode?, x: Int = -1): Int {
        if (root == null) {
            return 0
        }
        var ans = 1
        println("${root.`val`}, $x")
        if (x == -1 || x == root.`val`) {
            ans += findChild(root.left)
            ans += findChild(root.right)
            return ans
        } else {
            return findChild(root.left, x) + findChild(root.right, x)
        }
    }
}