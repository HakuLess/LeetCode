package leetcode.contest.cur.leetcode.b49

class Solution5705 {
    fun squareIsWhite(coordinates: String): Boolean {
        return ((coordinates[0] - 'a') + (coordinates[1] - '0')) % 2 == 0
    }
}