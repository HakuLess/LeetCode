package leetcode.normal

class Solution135 {
    fun candy(ratings: IntArray): Int {
        val n = ratings.size
        val left = IntArray(n) { 1 }
        val right = IntArray(n) { 1 }
        for (i in 1 until n) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1
            }
        }
        for (i in n - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1
            }
        }
        var ans = 0
        for (i in ratings.indices) {
            ans += maxOf(left[i], right[i])
        }
        return ans
    }
}