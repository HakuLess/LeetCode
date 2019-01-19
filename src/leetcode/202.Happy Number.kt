package leetcode

fun main(args: Array<String>) {
    isHappy(10001).print()
}

var source = arrayListOf<Int>()
fun isHappy(n: Int): Boolean {
    if (n in source) {
        return true
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