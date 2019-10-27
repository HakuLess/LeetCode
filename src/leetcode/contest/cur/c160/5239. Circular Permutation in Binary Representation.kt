package leetcode.contest.cur.c160

import leetcode.contest.utils.print
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solution5239()
    s.circularPermutation(2, 3).forEach {
        print("$it, ")
    }
    println()
    s.circularPermutation(3, 2).forEach {
        print("$it, ")
    }
    println()
    s.circularPermutation(16, 25768).forEach {
        print("$it, ")
    }
}

class Solution5239 {
    fun circularPermutation(n: Int, start: Int): List<Int> {
        val temp = dfs(n)
        val index = temp.indexOf(start)
        val ans = temp.subList(index, temp.lastIndex + 1)
        ans.addAll(temp.subList(0, index))
        return ans
    }

    private fun dfs(n: Int): ArrayList<Int> {
        if (n == 1) {
            return arrayListOf(0, 1)
        }
        val ans = arrayListOf<Int>()
        val left = dfs(n - 1)
        for (i in left.indices) {
            left[i] = left[i] * 2 + 1
        }
        ans.addAll(left)
        val right = dfs(n - 1)
        right.reverse()
        for (i in right.indices) {
            right[i] = right[i] * 2
        }
        ans.addAll(right)
        return ans
    }
}