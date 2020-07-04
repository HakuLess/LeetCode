package leetcode.contest.cur.cf654

fun main(args: Array<String>) {
    val (n, q) = readLine()!!.split(" ").map { it.toInt() }
    var s = readLine()!!.toCharArray()

    val seen = HashMap<Int, Int>()
    fun dfs(i: Int): Int {
        if (i in seen.keys) {
            return seen[i]!!
        }
        if (s[i] == '<') {
            if (i == 0) {
                seen[i] = 0
                return 0
            } else if (s[i - 1] == '<') {
                val ans = dfs(i - 1)
                seen[i] = ans
                return ans
            } else {
                seen[i] = i
                return i
            }
        } else {
            if (i == n) {
                seen[i] = n + 1
                return n + 1
            } else if (s[i + 1] == '>') {
                val ans = dfs(i + 1)
                seen[i] = ans
                return ans
            } else {
                seen[i] = i + 1
                return i + 1
            }
        }
    }

    for (i in 0 until q) {
        val (l, r) = readLine()!!.split(" ").map { it.toInt() }
        val map = HashMap<Int, Int>()
        for (i in l..r) {
            if (s[i - 1] == '<') s[i - 1] = '>'
            else s[i - 1] = '<'
        }
        for (i in 0 until n) {
            dfs(i)
        }
        for (i in l..r) {
            if (i !in seen.keys) {
                continue
            }
            map[seen[i]!!] = map.getOrDefault(seen[i], 0) + 1
        }
        println(map.maxBy { it.value }!!.value)
    }
}