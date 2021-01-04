package leetcode.contest.cur.codeforces.cf693

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    repeat(t) {
        readLine()!!
        val (n, m) = readLine()!!.split(' ').map { it.toInt() }
        val arr = ArrayList<Pair<Int, Int>>()
        repeat(m) {
            val (x, y) = readLine()!!.split(' ').map { it.toInt() }.sorted()
            arr.add(Pair(x - 1, y - 1))
        }
        val sorted = arr.sortedBy { it.second }
        var last = Pair(-1, -1)
        var b = false
        for (i in sorted.indices) {
            if (Pair(1 - sorted[i].first, sorted[i].second) in sorted) {
                if (last.first != -1) {
                    println("NO")
                    b = true
                    break
                }
            }
            if (sorted[i].first == 0) {
                if (last.first == -1) {
                    last = Pair(0, sorted[i].second)
                } else {
                    if (last.first == 0 && (sorted[i].second - last.second) % 2 != 0) {
                        last = Pair(-1, -1)
                    } else if (last.first == 1 && (sorted[i].second - last.second) % 2 == 0) {
                        last = Pair(-1, -1)
                    } else {
                        println("NO")
                        b = true
                        break
                    }
                }
            } else {
                if (last.first == -1) {
                    last = Pair(1, sorted[i].second)
                } else {
                    if (last.first == 1 && (sorted[i].second - last.second) % 2 != 0) {
                        last = Pair(-1, -1)
                    } else if (last.first == 0 && (sorted[i].second - last.second) % 2 == 0) {
                        last = Pair(-1, -1)
                    } else {
                        println("NO")
                        b = true
                        break
                    }
                }
            }
        }
        if (!b) {
            if (last.first == -1) {
                println("YES")
            } else {
                println("NO")
            }
        }
    }
}