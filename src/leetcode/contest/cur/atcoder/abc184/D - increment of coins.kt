package leetcode.contest.cur.atcoder.abc184

fun main(args: Array<String>) {
    val (a0, b0, c0) = readLine()!!.split(' ').map { it.toInt() }
    val seen = hashMapOf<String, Double>()
    fun dfs(a: Int, b: Int, c: Int, p: Double): Double {
        if (p == 0.0) return 0.0
        val key = intArrayOf(a, b, c).sorted().joinToString(",")
        if (key in seen) {
            return seen[key]!! * p
        }
        var cur = 0.0
        if (a == 100 || b == 100 || c == 100) {
            return p * (a + b + c - a0 - b0 - c0)
        }
        cur += dfs(a + 1, b, c, (a.toDouble() / (a + b + c)))
        cur += dfs(a, b + 1, c, (b.toDouble() / (a + b + c)))
        cur += dfs(a, b, c + 1, (c.toDouble() / (a + b + c)))
        seen[key] = cur
        return cur * p
    }
    println(dfs(a0, b0, c0, 1.0))
}