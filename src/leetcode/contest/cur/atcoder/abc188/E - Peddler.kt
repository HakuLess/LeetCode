package leetcode.contest.cur.atcoder.abc188

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.trim().split(' ').map(String::toInt)
    val price = readLine()!!.trim().split(' ').map(String::toInt).toIntArray()
    val town = List(n) { mutableListOf<Int>() }
    repeat(m) {
        val (x, y) = readLine()!!.trim().split(' ').map(String::toInt)
        town[x - 1].add(y - 1)
    }
    val minPrice = IntArray(n) { Int.MAX_VALUE }
    for (i in 0 until n) {
        for (j in town[i]) {
            minPrice[j] = minOf(minPrice[j], minOf(price[i], minPrice[i]))
        }
    }
    println((0 until n).map { i -> if (minPrice[i] == Int.MAX_VALUE) Int.MIN_VALUE else price[i] - minPrice[i] }.max()!!)
}