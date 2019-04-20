package leetcode.normal

fun main(args: Array<String>) {
    val source = 15
    fizzBuzz(source).forEach {
        println(it)
    }
}

fun fizzBuzz(n: Int): List<String> {
    val result = arrayListOf<String>()
    for (i in 1..n) {
        var item = ""
        if (i % 3 == 0) {
            item += "Fizz"
        }
        if (i % 5 == 0) {
            item += "Buzz"
        }
        if (item.isEmpty()) {
            result.add(i.toString())
        } else {
            result.add(item)
        }
    }
    return result
}