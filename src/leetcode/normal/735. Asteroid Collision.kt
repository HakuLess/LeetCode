package leetcode.normal

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution735()
    s.asteroidCollision(
            intArrayOf(5, 10, -5)
    ).print()
    s.asteroidCollision(
            intArrayOf(8, -8)
    ).print()
    s.asteroidCollision(
            intArrayOf(10, 2, -5)
    ).print()
    s.asteroidCollision(
            intArrayOf(-2, -1, 1, 2)
    ).print()
    s.asteroidCollision(
            intArrayOf(-2,-2,1,-2)
    ).print()
}

class Solution735 {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val ans = arrayListOf<Int>()
        val stack = Stack<Int>()
        for (i in asteroids.indices) {
            if (asteroids[i] < 0 && stack.isEmpty()) {
                ans.add(asteroids[i])
            } else if (asteroids[i] > 0) {
                stack.add(asteroids[i])
            } else {
                while (stack.isNotEmpty() && stack.peek() + asteroids[i] < 0) {
                    stack.pop()
                }
                if (stack.isEmpty()) {
                    ans.add(asteroids[i])
                } else if (stack.peek() + asteroids[i] == 0) {
                    stack.pop()
                }
            }
        }
        for (i in 0 until stack.size) {
            ans.add(stack[i])
        }
        return ans.toIntArray()
    }
}