package leetcode.contest.last.c173

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5322()
//    s.minDifficulty(intArrayOf(6, 5, 4, 3, 2, 1), 2).print()
//    s.minDifficulty(intArrayOf(1, 1, 1), 3).print()
//    s.minDifficulty(intArrayOf(7, 1, 7, 1, 7, 1), 3).print()
    s.minDifficulty(intArrayOf(11, 111, 22, 222, 33, 333, 44, 444), 6).print()
}

class Solution5322 {
    fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
        val meet = HashMap<Pair<Int, Int>, Int>()
        if (jobDifficulty.size < d) {
            return -1
        }
        if (jobDifficulty.size == d) {
            return jobDifficulty.sum()
        }
        fun helper(cur: Int, d: Int): Int {
            if (Pair(cur, d) in meet) {
                return meet[Pair(cur, d)]!!
            }
            if (d == 1) {
                var max = 0
                for (i in cur..jobDifficulty.lastIndex) {
                    max = maxOf(jobDifficulty[i], max)
                }
                return max
            }
            var dif = jobDifficulty[cur]
            var min = Int.MAX_VALUE / 2
            var index = cur + 1
            while (index <= jobDifficulty.lastIndex) {
                min = minOf(min, helper(index, d - 1) + dif)
                dif = maxOf(dif, jobDifficulty[index])
                index++
            }
//            println("$cur, $min")
            meet[Pair(cur, d)] = min
            return min
        }
        return helper(0, d)
    }
}