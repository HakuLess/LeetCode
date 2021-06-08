package leetcode.contest.last.c244

class Solution5777 {
//    fun reductionOperations(nums: IntArray): Int {
//        nums.sortDescending()
//        var ans = 0
//        for (i in nums.indices) {
//            if (i == 0 || nums[i] == nums[i - 1]) continue
//            ans += i
//        }
//        return ans
//    }

    fun reductionOperations(nums: IntArray): Int {
        val set = HashSet<Int>()
        nums.forEach {
            set.add(it)
        }
        val map = HashMap<Int, Int>()
        set.sorted().mapIndexed { index, i -> map[i] = index }
        return nums.sumBy { map[it]!! }
    }
}