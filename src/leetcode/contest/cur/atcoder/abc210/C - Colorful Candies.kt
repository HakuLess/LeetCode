package leetcode.contest.cur.atcoder.abc210

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val c = readLine()!!.split(" ").map { it.toInt() }
    var ans = 0
    var res = 0
    val map = HashMap<Int, Int>()
    for (i in c.indices) {
        if (i >= k) {
            map[c[i - k]] = map[c[i - k]]!! - 1
            if (map[c[i - k]] == 0) res--
        }
        if (map.getOrDefault(c[i], 0) == 0) {
            res++
        }
        map[c[i]] = map.getOrDefault(c[i], 0) + 1

        ans = maxOf(ans, res)
    }
    println(ans)
}