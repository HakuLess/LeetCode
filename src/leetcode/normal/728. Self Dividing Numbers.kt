package leetcode.normal

fun main(args: Array<String>) {
    selfDividingNumbers(1, 22)
}

fun selfDividingNumbers(left: Int, right: Int): List<Int> {

    val result = arrayListOf<Int>()

    for (i in left..right) {
        var add = true
        i.toString().forEach {
            if (it == '0' || i % Integer.parseInt(it.toString()) != 0) {
                add = false
            }
        }
        if (add) {
            result.add(i)
        }
    }

    result.forEach {
        println(it)
    }
    return result
}