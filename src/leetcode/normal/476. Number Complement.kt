package leetcode.normal

fun findComplement(num: Int): Int {
    var times = 2L
    while (times <= num) {
        times *= 2
    }
    return (times - num - 1).toInt()
}