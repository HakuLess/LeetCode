package leetcode.contest.last.c244

import leetcode.contest.utils.*

fun main(args: Array<String>) {
    val s = Solution5779()
//    s.minWastedSpace(intArrayOf(1, 8, 9, 2, 7), "[[9],[10,6],[2]]".toGrid()).print()
    s.minWastedSpace(intArrayOf(2, 3, 5), "[[4,8],[2,8]]".toMatrix().matrix).print()
}

class Solution5779 {
    fun minWastedSpace(packages: IntArray, boxes: Array<IntArray>): Int {
        val mod = 1000000007L
        packages.sort()
        val preSum = packages.preSumArray()
        var ans = Long.MAX_VALUE
        for (i in boxes.indices) {
            val it = boxes[i].sorted()
            if (it.last() < packages.last()) {
                continue
            }
            var preIndex = 0
            var tmp = 0L
            it.forEach {
                val index = packages.biLastIndexOf { item -> item <= it }
                tmp += (index - preIndex + 1) * it.toLong() - (preSum[index + 1] - preSum[preIndex])
                preIndex = index + 1
                if (preIndex == packages.size) return@forEach
            }
            ans = minOf(ans, tmp)
        }
        return if (ans == Long.MAX_VALUE) -1 else (ans % mod).toInt()
    }
}