package leetcode.contest.last.c233

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5711()
    s.maxValue(4, 2, 6).print()
    s.maxValue(6, 1, 10).print()
    s.maxValue(1, 0, 24).print()
}

class Solution5711 {
    fun maxValue(n: Int, index: Int, maxSum: Int): Int {
        fun sum(start: Int, count: Int): Long {
            if (count == 0) return 0L
            val minCount = minOf(start, count)
            var sum = start * minCount.toLong() - (minCount - 1) * minCount.toLong() / 2
            if (count > minCount) sum += count - minCount
            return sum
        }

        var l = 1
        var r = maxSum - n + 1
        while (l < r) {
            val mid = l + (r - l + 1) / 2
            val sumLeft = sum(mid - 1, index)
            val sumRight = sum(mid, n - index)
            if (sumLeft + sumRight <= maxSum) l = mid
            else r = mid - 1
        }
        return l
    }
}