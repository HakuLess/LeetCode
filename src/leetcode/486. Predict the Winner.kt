package leetcode

import kotlin.math.max

//todo didn't finish
fun PredictTheWinner(nums: IntArray): Boolean {

    val matrix = Array(nums.size) {
        IntArray(nums.size)
    }

    for (i in 0 until nums.size) {
        for (j in i until nums.size) {
            when {
                j - i > 1 -> {
                    matrix[i][j] = max(matrix.get(i + 2, j) + nums[i], matrix.get(i, j + 2) + nums[j])
                }
                j == i -> matrix[i][j] = nums[i]
                else -> {
                    matrix[i][j] = max(nums[i], nums[j])
                }
            }
        }
    }
    return matrix[0][nums.size - 1] > nums.sum() / 2
}

fun Array<IntArray>.get(i: Int, j: Int): Int {
    return this.getOrElse(i) {
        IntArray(j + 1)
    }[j]
}