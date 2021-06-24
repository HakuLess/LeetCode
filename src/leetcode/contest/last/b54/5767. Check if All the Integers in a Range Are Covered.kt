package leetcode.contest.last.b54

class Solution5767 {
    fun isCovered(ranges: Array<IntArray>, left: Int, right: Int): Boolean {
        return (left..right).all { v ->
            ranges.any {
                v in it[0]..it[1]
            }
        }
    }
}