package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    checkPerfectNumber(28).print()
}

fun checkPerfectNumber(num: Int): Boolean {
    if (num == 0 || num == 1) {
        return false
    }
    var sum = 0
    for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) {
            sum += i
            if (num / i != i) {
                sum += num / i
            }
        }
    }
    return sum + 1 == num
}