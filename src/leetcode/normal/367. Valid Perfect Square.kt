package leetcode.normal

fun isPerfectSquare(num: Int): Boolean {
    var left = 0
    var right = num
    while (left <= right) {
        val mid = (left + (right - left) / 2).toLong()
        when {
            mid * mid == num.toLong() -> return true
            mid * mid < num -> left = (mid + 1).toInt()
            else -> right = (mid - 1).toInt()
        }
    }
    return false
}