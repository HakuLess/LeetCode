package leetcode.contest.cur.atcoder.abc174

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.toString().split(' ').map { it.toInt() }
    val arr = readLine()!!.toString().split(' ').map { it.toInt() }.toIntArray()
    var ans = 0
    fun check(x: Int): Boolean {
        var count = 0L
        for (i in 0 until n) {
            count += (arr[i] + x - 1) / x - 1
        }
        return count <= k
    }

    var l = 1
    var r = arr.max()!!
    while (l <= r) {
        val mid = l + (r - l) / 2
        if (check(mid)) {
            ans = mid
            r = mid - 1
        } else {
            l = mid + 1
        }
    }
    println(ans)
}