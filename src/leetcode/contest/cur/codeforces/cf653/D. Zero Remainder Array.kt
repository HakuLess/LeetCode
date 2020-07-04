package leetcode.contest.cur.cf653

import leetcode.contest.utils.printInt

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val (n, k) = readLine()!!.split(" ").map { it.toLong() }
        val array = readLine()!!.split(" ").map { it.toLong() }.toLongArray()

        val map = sortedMapOf<Long, Long>()
        array.forEach {
            if (it % k != 0L) {
                map[k - it % k] = map.getOrDefault(k - it % k, 0) + 1
            }
        }
        if (map.isEmpty()) {
            println(0)
            continue
        }
        var max = 0L
        var maxKey = 0L
        map.forEach {
//            println("${it.key} : ${it.value }")
            if (it.value >= max) {
                max = it.value
                maxKey = it.key
            }
        }
        println((max - 1) * k + maxKey + 1)
    }
}