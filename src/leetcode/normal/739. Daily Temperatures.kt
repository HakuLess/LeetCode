package leetcode.normal

import java.util.*

class Solution739 {
    fun dailyTemperatures(T: IntArray): IntArray {
        val ans = IntArray(T.size)
        val stack = Stack<Pair<Int, Int>>()
        for (i in T.indices) {
            while (stack.isNotEmpty() && stack.peek().first < T[i]) {
                val item = stack.pop()
                ans[item.second] = i - item.second
            }
            stack.push(Pair(T[i], i))
        }
        return ans
    }
}