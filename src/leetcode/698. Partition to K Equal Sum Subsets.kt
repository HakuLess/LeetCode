package leetcode


fun main(args: Array<String>) {
    val s = Solution698()
//    s.canPartitionKSubsets(intArrayOf(4, 3, 2, 3, 5, 2, 1), 4).print()
    s.canPartitionKSubsets(intArrayOf(18, 20, 39, 73, 96, 99, 101, 111, 114, 190, 207, 295, 471, 649, 700, 1037), 4).print()
//    s.canPartitionKSubsets(intArrayOf(10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6), 3).print()
}

class Solution698 {

//    fun search(groups: IntArray, row: Int, nums: IntArray, target: Int): Boolean {
//
//        var key = "$row, $target: "
//        groups.forEach {
//            key += "$it "
//        }
//        println(key)
//
//        var row = row
//        if (row < 0) return true
//        val v = nums[row--]
//        for (i in groups.indices) {
//            if (groups[i] + v <= target) {
//                groups[i] += v
//                if (search(groups, row, nums, target)) return true
//                groups[i] -= v
//            }
//            if (groups[i] == 0) break
//        }
//        return false
//    }
//
//    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
//        var k = k
//        val sum = nums.sum()
//        if (sum % k > 0) return false
//        val target = sum / k
//
//        nums.sort()
//        var row = nums.size - 1
//        if (nums[row] > target) return false
//        while (row >= 0 && nums[row] == target) {
//            row--
//            k--
//        }
//        return search(IntArray(k), row, nums, target)
//    }

    var map = hashMapOf<String, Boolean>()

    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        if (nums.isEmpty()) {
            return false
        }
        val sum = nums.sum()
        if (sum % k != 0) {
            return false
        }

        nums.sortDescending()
        val target = sum / k
        val b = IntArray(k) { 0 }
        if (getAns(0, k, b, target, nums)) {
            return true
        }
        return false
    }

    private fun getAns(i: Int, k: Int, b: IntArray, target: Int, nums: IntArray): Boolean {
        var key = "$i, $k, $target: "
        b.sortDescending()
        b.forEach {
            key += "$it "
        }
        println(key)
        if (map.containsKey(key)) {
            return map[key]!!
        }

        if (b.any { it > target }) {
            return false
        }

        if (i == nums.size) {
            return b.all { it == target }
        }

        var ans = false
        for (t in 0 until k) {
            val temp = b.copyOf()

            if (temp[t] + nums[i] <= target) {
                temp[t] += nums[i]
                ans = ans || getAns(i + 1, k, temp, target, nums)
            }
        }

        map[key] = ans
        return ans
    }
}