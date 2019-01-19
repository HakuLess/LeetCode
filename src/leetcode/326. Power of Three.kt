package leetcode

fun isPowerOfThree(n: Int): Boolean {
    if (n <= 0) {
        return false
    }
    return if (n == 1) {
        true
    } else {
        (n % 3 == 0) && isPowerOfThree(n / 3)
    }
}