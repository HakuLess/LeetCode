package leetcode.normal

class Solution575 {
    fun distributeCandies(candies: IntArray): Int {
        val count = candies.size / 2
        val kind = candies.distinct().size
        return minOf(kind, count)
    }
}