package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    gridIllumination(5, arrayOf(
            intArrayOf(0, 0),
            intArrayOf(4, 4)
    ),
            arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 0)
            )).print()
}

fun gridIllumination(N: Int, lamps: Array<IntArray>, queries: Array<IntArray>): IntArray {
    val res = IntArray(queries.size)
    val set = HashSet<Int>()
    for (i in 0 until queries.size) {
        val x = queries[i][0]
        val y = queries[i][1]
        for (j in 0 until lamps.size) {
            if (set.contains(lamps[j][0] * N + lamps[j][1])) {
                continue
            }
            if (x == lamps[j][0] || y == lamps[j][1] ||
                    x - lamps[j][0] == y - lamps[j][1] ||
                    x - lamps[j][0] == -y + lamps[j][1]) {
                res[i] = 1
                break
            }
        }
        set.add(x * N + y)
        set.add(x * N + (y - 1))
        set.add(x * N + (y + 1))
        set.add((x - 1) * N + y)
        set.add((x - 1) * N + (y - 1))
        set.add((x - 1) * N + (y + 1))
        set.add((x + 1) * N + (y - 1))
        set.add((x + 1) * N + (y + 1))
        set.add((x + 1) * N + y)
    }
    return res
}