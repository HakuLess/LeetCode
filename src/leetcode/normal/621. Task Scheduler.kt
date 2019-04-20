package leetcode.normal

fun main(args: Array<String>) {

//    val charArray = charArrayOf('A', 'A', 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'C')
    val charArray = charArrayOf('A', 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C')
//    val charArray = charArrayOf('A', 'A', 'A', 'B', 'B', 'B', 'C')
    val n = 2
    println(leastInterval(charArray, n))
}

fun leastInterval(tasks: CharArray, n: Int): Int {
    val arrays = IntArray(26)
    tasks.forEach {
        arrays[it - 'A']++
    }

    arrays.sortDescending()
    var result = 0

    // count kinds of char
    val c = arrays.count {
        it != 0
    }

    var offset = 1
    var t = 1
    while (t < 26 && arrays[t] == arrays[t - 1]) {
        offset++
        t++
    }

    val max = arrays[0]
    if (c <= n + 1) {
        println("ZZZZ")
        result = (max - 1) * (n + 1) + offset
    } else if (c > n) {
        var first = 0
        for (i in 0..n) {
            first += arrays[i]
        }
        var second = 0
        for (i in (n + 1)..25) {
            second += arrays[i]
        }

        result = if (first + second < max * (n + 1)) {
            println("XXXX")
            (max - 1) * (n + 1) + offset
        } else {
            println("YYYY")
            first + second
//            println("$first $second")
//            Math.ceil((first + second) / (n + 1).toDouble()).toInt()
        }
    }

    return result
}