package leetcode.normal

import kotlin.math.abs
import kotlin.math.max

fun stoneGame(piles: IntArray): Boolean {
    return piles[0] > getMaxDiff(piles.copyOfRange(1, piles.size)) &&
            piles[piles.size - 1] > getMaxDiff(piles.copyOfRange(0, piles.size - 1))
}

fun getMaxDiff(piles: IntArray): Int {
    return when {
        piles.isEmpty() -> 0
        piles.size == 1 -> piles[0]
        piles.size == 2 -> abs(piles[0] - piles[1])
        else -> max(abs(piles[0] - getMaxDiff(piles.copyOfRange(1, piles.size))),
                abs(piles[piles.size - 1] - getMaxDiff(piles.copyOfRange(0, piles.size - 1))))
    }
}