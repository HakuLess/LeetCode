package leetcode.contest.cur.leetcode.c212

class Solution1630 {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val ans = arrayListOf<Boolean>()
        fun check(sort: List<Int>): Boolean {
            if (sort.size <= 1) return false
            val diff = sort[1] - sort[0]
            for (i in 1 until sort.size) {
                if (sort[i] - sort[i - 1] != diff) {
                    return false
                }
            }
            return true
        }
        for (i in l.indices) {
            ans.add(check(nums.toList().subList(l[i], r[i] + 1).sorted()))
        }
        return ans
    }
}