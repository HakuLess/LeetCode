package leetcode


fun findTargetSumWays(nums: IntArray, S: Int): Int {
    var ans = 0
    ans += dfs(0, 0, nums, S)
    return ans
}

fun dfs(cur: Int, pos: Int, nums: IntArray, target: Int): Int {
    if (pos == nums.size) {
        return if (cur == target) {
            1
        } else {
            0
        }
    }

    return dfs(cur + nums[pos], pos + 1, nums, target) + dfs(cur - nums[pos], pos + 1, nums, target)
}