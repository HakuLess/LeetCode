package leetcode

import java.util.*


fun powerfulIntegers(x: Int, y: Int, bound: Int): List<Int> {
    val result = hashSetOf<Int>()
    val stack: Stack<Pair<Int, Int>> = Stack()
    stack.push(Pair(1, 1))
    while (stack.isNotEmpty()) {
        val pow = stack.pop()
        val item = pow.first + pow.second

        if (item <= bound) {
            result.add(item)

            if (x != 1) {
                stack.push(Pair(pow.first * x, pow.second))
            }
            if (y != 1) {
                stack.push(Pair(pow.first, pow.second * y))
            }
        }
    }

    return result.toList()
}