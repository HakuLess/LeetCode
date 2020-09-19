package leetcode.contest.cur.leetcode.b35

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5506()
//    s.isPrintable(
//            arrayOf(
//                    intArrayOf(1, 1, 1, 1),
//                    intArrayOf(1, 2, 2, 1),
//                    intArrayOf(1, 2, 2, 1),
//                    intArrayOf(1, 1, 1, 1)
//            )
//    ).print()

    s.isPrintable(
            arrayOf(
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(1, 1, 3, 3),
                    intArrayOf(1, 1, 3, 4),
                    intArrayOf(5, 5, 1, 4)
            )
    ).print()

}

class Solution5506 {
    fun isPrintable(targetGrid: Array<IntArray>): Boolean {
        val count = IntArray(100)
        val n = targetGrid.size
        val m = targetGrid[0].size

        val seen = HashSet<Int>()
        for (i in 0 until n) {
            for (j in 0 until m) {
                count[targetGrid[i][j]]++
                seen.add(targetGrid[i][j])
            }
        }

        fun check(a: Int, b: Int, c: Int, d: Int, v: Int): Boolean {
            var ans = 0
            for (i in a..b) {
                for (j in c..d) {
                    if (targetGrid[i][j] == v) {
                        ans++
                    } else if (targetGrid[i][j] != 0) {
                        return false
                    }
                }
            }
            return ans == count[v]
        }

        do {
            var check = false
            for (v in seen) {
                for (a in 0 until n) {
                    for (b in a until n) {
                        for (c in 0 until m) {
                            for (d in c until m) {
                                if (check(a, b, c, d, v)) {
                                    println("check $v")
                                    seen.remove(v)
                                    check = true
                                    for (i in a..b) {
                                        for (j in c..d) {
                                            targetGrid[i][j] = 0
                                        }
                                    }
                                }
                                if (check) break
                            }
                            if (check) break
                        }
                        if (check) break
                    }
                    if (check) break
                }
                if (check) break
            }
        } while (check && seen.isNotEmpty())

        return targetGrid.sumBy { it.sum() } == 0
    }
}