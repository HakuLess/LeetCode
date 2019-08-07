package leetcode.contest.last.c148

import leetcode.contest.utils.*

fun main(args: Array<String>) {
    val s = Solution1146()
    s.btreeGameWinningMove(
            arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11).toTree(),
            11,
            3
    ).print()
}

class Solution1146 {
    fun btreeGameWinningMove(root: TreeNode?, n: Int, x: Int): Boolean {
        val node = root.find(x)!!

        val left = node.left.count()
        val right = node.right.count()
        println("$left , $right, $n")

        return left > n / 2 || right > n / 2 || left + right + 1 <= n / 2
    }
}