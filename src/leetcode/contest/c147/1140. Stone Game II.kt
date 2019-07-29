package leetcode.contest.c147

import leetcode.print


fun main(args: Array<String>) {
    val s = Solution1140()
//    s.stoneGameII(
//            intArrayOf(2, 7, 9, 4, 4)
//    ).print()

//    s.stoneGameII(
//            intArrayOf(3111, 4303, 2722, 2183, 6351, 5227, 8964, 7167, 9286, 6626, 2347, 1465, 5201, 7240, 5463, 8523, 8163, 9391, 8616, 5063, 7837, 7050, 1246, 9579, 7744, 6932, 7704, 9841, 6163, 4829, 7324, 6006, 4689, 8781, 621)
//    ).print()

    s.stoneGameII(
            intArrayOf(8270, 7145, 575, 5156, 5126, 2905, 8793, 7817, 5532, 5726, 7071, 7730, 5200, 5369, 5763, 7148, 8287, 9449, 7567, 4850, 1385, 2135, 1737, 9511, 8065, 7063, 8023, 7729, 7084, 8407)
    ).print()
}

class Solution1140 {
    private var dp: Array<IntArray>? = null

    fun stoneGameII(piles: IntArray): Int {
        val len = piles.size
        dp = Array(len) { IntArray(len) }
        return getMax(piles, 0, 1, piles.sum())
    }

    private fun getMax(piles: IntArray, i: Int, M: Int, sum: Int): Int {
        if (i >= piles.size) return 0
        if (dp!![i][M] == 0) {
            var take = 0
            var max = 0
            var j = 1
            while (j <= M * 2 && i + j <= piles.size) {
                take += piles[i + j - 1]
                max = maxOf(max, sum - getMax(piles, i + j, maxOf(j, M), sum - take))
                j++
            }
            dp!![i][M] = max
        }
        return dp!![i][M]
    }

//    fun stoneGameII(piles: IntArray): Int {
//        return getPiles(piles.toList(), 2)
//    }
//
//    private fun getPiles(piles: List<Int>, cur: Int): Int {
//        if (cur >= piles.size) {
//            return piles.sum()
//        }
//
//        var max = 0
//        for (i in 1..cur) {
//            max = maxOf(max, piles.sum() - getPiles(piles.subList(i, piles.lastIndex + 1).toList(), maxOf(i * 2, cur)))
//            println("${piles[0]} : $i $max")
//        }
//        return max
//    }
}