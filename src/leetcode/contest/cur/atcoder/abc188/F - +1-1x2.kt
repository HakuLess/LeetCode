package leetcode.contest.cur.atcoder.abc188

fun main(args: Array<String>) {
    val (x, y) = readLine()!!.trim().split(' ').map(String::toLong)
    val seen = HashMap<Long, Long>()
    fun dfs(y: Long): Long {
        if (y in seen.keys) return seen[y]!!
        if (x >= y) {
            return (x - y).also { seen[y] = it }
        }
        return minOf(y - x, dfs(y / 2) + 1 + y % 2, dfs((y + 1) / 2) + 1 + y % 2).also { seen[y] = it }
    }
    println(dfs(y))
}