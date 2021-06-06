package leetcode.contest.cur.leetcode.c244

class Solution5777 {
    fun reductionOperations(nums: IntArray): Int {
        val set = HashSet<Int>()
        nums.forEach {
            set.add(it)
        }
        val map = HashMap<Int, Int>()
        set.sorted().mapIndexed { index, i -> map[i] = index }
        var ans = 0
        nums.forEach {
            ans += map[it]!!
        }
        return ans
    }
}