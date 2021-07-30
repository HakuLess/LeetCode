package leetcode.normal

class Solution985 {
    fun sumEvenAfterQueries(nums: IntArray, queries: Array<IntArray>): IntArray {
        var cur = nums.sumBy { if (it % 2 == 0) it else 0 }
        return queries.map {
            if (nums[it[1]] % 2 == 0)
                cur -= nums[it[1]]
            nums[it[1]] += it[0]
            if (nums[it[1]] % 2 == 0)
                cur += nums[it[1]]
            cur
        }.toIntArray()
    }
}