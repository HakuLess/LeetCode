package leetcode.contest.cur.b25

class Solution5384 {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
        val max = candies.max()!!
        return candies.map {
            it + extraCandies >= max
        }.toBooleanArray()
    }
}