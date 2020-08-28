package leetcode.contest.cur.codeforces.ecr94

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val arr = ArrayList(readLine()!!.split(' ').map { it.toInt() })

    fun dfs(l: Int, r: Int): Int {
        if (l > r) return 0
        var min = Int.MAX_VALUE
        var mid = -1
        for (i in l..r) {
            if (arr[i] < min) {
                min = arr[i]
                mid = i
            }
        }
        for (i in l..r) arr[i] -= min
        return minOf(min + dfs(l, mid - 1) + dfs(mid + 1, r), r - l + 1)
    }

    println(dfs(0, n - 1))
}