package leetcode.normal

fun trailingZeroes(n: Int): Int {
    return if (n >= 5) {
        n / 5 + trailingZeroes(n / 5)
    } else {
        0
    }
}