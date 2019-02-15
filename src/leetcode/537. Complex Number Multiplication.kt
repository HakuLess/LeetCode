package leetcode

fun main(args: Array<String>) {
    complexNumberMultiply("1+1i", "1+1i").print()
}

fun complexNumberMultiply(a: String, b: String): String {
    var array = a.split('+')
    array.forEach {
        println(it)
    }
    val ax = Integer.parseInt(array[0])
    val ay = Integer.parseInt(array[1].substring(0, array[1].lastIndex))

    array = b.split('+')
    val bx = Integer.parseInt(array[0])
    val by = Integer.parseInt(array[1].substring(0, array[1].lastIndex))

    return "${ax * bx - ay * by}+${ax * by + ay * bx}i"
}