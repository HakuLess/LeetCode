package leetcode.contest.last.b25

class Solution5384 {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
        val max = candies.maxOrNull()!!
        return candies.map {
            it + extraCandies >= max
        }.toBooleanArray()
    }
}