package leetcode

fun main(args: Array<String>) {
    convertToBase7(49).print()
}

fun convertToBase7(num: Int): String {
    var result = 0
    var input = num
    var pos = 1

    while (input != 0) {
        result += input % 7 * pos
        pos *= 10
        input /= 7
        println("$result $input")
    }
    return result.toString()
}