package leetcode

fun integerBreak(n: Int): Int {
    return when {
        n < 2 -> 0
        n == 2 -> 1
        n == 3 -> 2
        n == 4 -> 4
        n == 5 -> 6
        n == 6 -> 9
        else -> {
            integerBreak(n - 3) * 3
        }
    }
}