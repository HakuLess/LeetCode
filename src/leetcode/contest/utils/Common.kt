package leetcode.contest.utils

fun String.toIntArray(): IntArray {
    return this.trim { it == '[' || it == ']' }.split(',').map {
        it.toInt()
    }.toIntArray()
}