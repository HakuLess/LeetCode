package leetcode

class Solution416 {
    fun canPartition(nums: IntArray): Boolean {
        return canPartitionKSubsets(nums, 2)
    }

    private fun search(groups: IntArray, row: Int, nums: IntArray, target: Int): Boolean {
//        var key = "$row, $target: "
//        groups.forEach {
//            key += "$it "
//        }
//        println(key)

        var row = row
        if (row < 0) return true
        val v = nums[row--]
        for (i in groups.indices) {
            if (groups[i] + v <= target) {
                groups[i] += v
                if (search(groups, row, nums, target)) return true
                groups[i] -= v
            }
            if (groups[i] == 0) break
        }
        return false
    }

    private fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        var k = k
        val sum = nums.sum()
        if (sum % k > 0) return false
        val target = sum / k

        nums.sort()
        var row = nums.size - 1
        if (nums[row] > target) return false
        while (row >= 0 && nums[row] == target) {
            row--
            k--
        }
        return search(IntArray(k), row, nums, target)
    }
}