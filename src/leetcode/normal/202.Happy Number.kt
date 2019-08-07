package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    isHappy(2).print()
}

var source = hashSetOf<Int>()

fun isHappy(n: Int): Boolean {
    if (n in source) {
        return false
    }
    source.add(n)
    var res = n
    val a = arrayListOf<Int>()
    while (res != 0) {
        a.add(res % 10)
        res /= 10
    }

    var b = 0
    a.forEach {
        b += it * it
    }

    return if (b == 1) {
        true
    } else {
        isHappy(b)
    }
}