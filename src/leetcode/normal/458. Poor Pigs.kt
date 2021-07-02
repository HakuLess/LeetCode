package leetcode.normal

import kotlin.math.ceil
import kotlin.math.ln

class Solution458 {
    fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
        val states = minutesToTest / minutesToDie + 1
        return ceil(ln(buckets.toDouble()) / ln(states.toDouble())).toInt()
    }
}