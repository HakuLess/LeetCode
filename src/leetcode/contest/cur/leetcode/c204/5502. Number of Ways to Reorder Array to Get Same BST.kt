package leetcode.contest.cur.leetcode.c204

import leetcode.contest.utils.TreeNode
import leetcode.contest.utils.count
import leetcode.contest.utils.print
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solution5502()
//    s.numOfWays(intArrayOf(3, 4, 5, 1, 2)).print()
//    s.numOfWays(intArrayOf(9, 4, 2, 1, 3, 6, 5, 7, 8, 14, 11, 10, 12, 13, 16, 15, 17, 18)).print()
//    s.numOfWays(intArrayOf(10, 23, 12, 18, 4, 29, 2, 8, 41, 31, 25, 21, 14, 35, 26, 5, 19, 43, 22, 37, 9, 20, 44, 28, 1, 39, 30, 38, 36, 6, 13, 16, 27, 17, 34, 7, 15, 3, 11, 24, 42, 33, 40, 32)).print()
    s.numOfWays(intArrayOf(30, 11, 46, 3, 29, 22, 37, 32, 13, 49, 48, 16, 40, 8, 24, 44, 9, 39, 25, 21, 41, 26, 43, 19, 47, 7, 10, 31, 45, 4, 35, 14, 20, 23, 15, 17, 38, 2, 6, 18, 5, 33, 27, 36, 42, 28, 12, 34, 1)).print()
}

class Solution5502 {
    val mod = 1000000007L

    fun numOfWays(nums: IntArray): Int {
        val a = arrayListOf<Int>()
        a.addAll(nums.toList())
        val root = geneBST(a)
        fun dfs(root: TreeNode?): BigInteger {
            if (root == null) return BigInteger.ONE
            val m = root.left.count().toLong()
            val n = root.right.count().toLong()
            var ans = c(BigInteger.valueOf(m + n), BigInteger.valueOf(n))
            ans = ans.multiply(dfs(root.left))
            ans = ans.multiply(dfs(root.right))
            return ans
        }
        return (dfs(root).mod(BigInteger.valueOf(mod))).toInt() - 1
    }

    fun c(m: BigInteger, n: BigInteger): BigInteger {
        var a = BigInteger.ONE
        var b = BigInteger.ONE
        var result = BigInteger.ONE
        val qc = minOf(n, m - n)
        for (j in 0 until qc.toInt()) {
            a = a.multiply(m - BigInteger.valueOf(j.toLong()))
            b = b.multiply(qc - BigInteger.valueOf(j.toLong()))
        }
        result = a / b
        return result
    }

    fun geneBST(nums: ArrayList<Int>): TreeNode? {
        if (nums.isEmpty()) {
            return null
        }
        val left = arrayListOf<Int>()
        val right = arrayListOf<Int>()
        for (i in 1 until nums.size) {
            if (nums[i] > nums[0]) {
                right.add(nums[i])
            } else {
                left.add(nums[i])
            }
        }

        val root = TreeNode(nums[0])
        root.left = geneBST(left)
        root.right = geneBST(right)
        return root
    }
}