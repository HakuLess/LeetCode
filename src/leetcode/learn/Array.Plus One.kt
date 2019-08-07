package leetcode.learn

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val intArray = intArrayOf(9, 8, 9, 9)
    plusOne(intArray).print()
}

fun plusOne(digits: IntArray): IntArray {

    if (digits.all { it == 9 }) {
        val result = IntArray(digits.size + 1)
        result[0] = 1
        return result
    }


    for (i in digits.size - 1 downTo 0) {
        digits[i] += 1
        if (digits[i] == 10) {
            digits[i] = 0
        } else {
            return digits
        }
    }

    return intArrayOf()
}