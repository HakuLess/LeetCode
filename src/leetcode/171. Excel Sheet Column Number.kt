package leetcode

fun titleToNumber(s: String): Int {
    var result = 0
    var pos = 1
    s.reversed().forEach {
        result += (it - 'A' + 1) * pos
        pos *= 26
    }
    return result
}