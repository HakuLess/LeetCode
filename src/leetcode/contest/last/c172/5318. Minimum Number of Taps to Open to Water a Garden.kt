package leetcode.contest.last.c172

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5318()
//    s.minTaps(5, intArrayOf(3, 4, 1, 1, 0, 0)).print()
    s.minTaps(7, intArrayOf(1, 2, 1, 0, 2, 1, 0, 1)).print()
//    s.minTaps(17, intArrayOf(0, 3, 3, 2, 2, 4, 2, 1, 5, 1, 0, 1, 2, 3, 0, 3, 1, 1)).print()
//    s.minTaps(3, intArrayOf(0, 0, 0, 0)).print()
}

class Solution5318 {
    fun minTaps(n: Int, ranges: IntArray): Int {
        val bounds = IntArray(n + 1)
        ranges.forEachIndexed { index, it ->
            val left = maxOf(0, index - it)
            val right = minOf(n, index + it)
            bounds[left] = right
            println("$left set $right")
        }
        bounds.print()
        var ans = 1
        var cur = bounds[0]
        var next = bounds[0]

        for (i in 1..n) {
            if (i > next) return -1
            if (i > cur) {
                ans++
                cur = next
            }
            if (bounds[i] > next) {
                next = bounds[i]
            }
        }
        return ans
    }

//    fun minTaps(n: Int, ranges: IntArray): Int {
//        val intervals = ArrayList<Pair<Int, Int>>()
//        for (i in 0..n) {
//            intervals.add(Pair(i - ranges[i], i + ranges[i]))
//        }
//        intervals.sortBy { it.first }
//        var ans = 0
//        var cur = 0
//        var next = 0
//        var index = 0
//        while (index <= n) {
//            val it = intervals[index]
//            if (it.first <= cur) {
//                next = maxOf(next, it.second)
//                index++
//                if (next >= n) {
//                    return ans + 1
//                }
//            } else {
//                if (next == cur) {
//                    return -1
//                }
//                cur = next
//                ans++
//            }
//        }
//        return ans
//    }

//    fun minTaps(n: Int, ranges: IntArray): Int {
//        var p = 0
//        var q = 0
//        var res = 0
//        while (p < n) {
//            for (i in 0..n) {
//                if (i - ranges[i] <= p) {
//                    q = maxOf(q, i + ranges[i])
//                }
//            }
//            if (p == q) return -1
//            p = q
//            res++
//        }
//        return res
//    }
}