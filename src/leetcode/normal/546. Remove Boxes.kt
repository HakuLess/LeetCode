package leetcode.normal

class Solution546 {

    fun removeBoxes(boxes: IntArray): Int {
        val dp = Array(100) { Array(100) { IntArray(100) } }
        return calculatePoints(boxes, dp, 0, boxes.size - 1, 0)
    }

    private fun calculatePoints(boxes: IntArray, dp: Array<Array<IntArray>>, l: Int, r: Int, k: Int): Int {
        var r = r
        var k = k
        if (l > r) return 0
        if (dp[l][r][k] != 0) return dp[l][r][k]
        while (r > l && boxes[r] == boxes[r - 1]) {
            r--
            k++
        }
        dp[l][r][k] = calculatePoints(boxes, dp, l, r - 1, 0) + (k + 1) * (k + 1)
        for (i in l until r) {
            if (boxes[i] == boxes[r]) {
                dp[l][r][k] = maxOf(dp[l][r][k],
                        calculatePoints(boxes, dp, l, i, k + 1) + calculatePoints(boxes, dp, i + 1, r - 1, 0))
            }
        }
        return dp[l][r][k]
    }
}