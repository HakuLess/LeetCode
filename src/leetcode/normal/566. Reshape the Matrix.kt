package leetcode.normal

fun matrixReshape(nums: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
    if (nums.isEmpty() || nums[0].isEmpty()) {
        return emptyArray()
    }

    val column = nums[0].size
    val sum = nums.size * nums[0].size
    if (sum != r * c) {
        return nums
    }

    val ans = Array(r) { IntArray(c) }
    for (i in 0 until r) {
        for (j in 0 until c) {
            println("${(i * c + j) / column}  ${(i * c + j) % column}")
            ans[i][j] = nums[(i * c + j) / column][(i * c + j) % column]
        }
    }
    return ans
}