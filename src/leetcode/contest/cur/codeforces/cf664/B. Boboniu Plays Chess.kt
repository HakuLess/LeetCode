package leetcode.contest.cur.codeforces.cf664

fun main(args: Array<String>) {
    var (m, n, x, y) = readLine()!!.split(' ').map { it.toInt() }
    val ans = ArrayList<Pair<Int, Int>>()
    while (x != 1 && y != 1) {
        ans.add(Pair(x, y))
        if (x != 1) {
            x--
            continue
        }
        if (y != 1) {
            y--
            continue
        }
    }
    ans.add(Pair(x, y))
    for (i in 1..m) {
        if (i % 2 == 1) {
            for (j in 1..n) {
                if (Pair(i, j) !in ans) {
                    ans.add(Pair(i, j))
                }
            }
        } else {
            for (j in n downTo 1) {
                if (Pair(i, j) !in ans) {
                    ans.add(Pair(i, j))
                }
            }
        }
    }
    ans.forEach {
        println("${it.first} ${it.second}")
    }
}