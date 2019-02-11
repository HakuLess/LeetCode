package leetcode

fun main(args: Array<String>) {
    reverse(1534236469).print()
}

fun reverse(x: Int): Int {
    var num = x
    var result = 0
    while (num != 0) {
        val pop = num % 10
        num /= 10
        if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && pop > 7) return 0
        if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && pop < -8) return 0
        result = result * 10 + pop
    }

    return result
}