package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution40()
    s.combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8).print()
}

class Solution40 {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = arrayListOf<ArrayList<Int>>()
        candidates.sort()
        fun dfs(target: Int, ans: ArrayList<Int>, startIndex: Int) {
            if (target == 0) {
                result.add(ans)
                return
            }
            if (target < 0 || startIndex >= candidates.size) {
                return
            }
            for (i in startIndex until candidates.size) {
                if (i > startIndex && candidates[i] == candidates[i - 1])
                    continue
                val temp = ArrayList(ans)
                temp.add(candidates[i])
                dfs(target - candidates[i], temp, i + 1)
            }
        }
        for (i in candidates.indices) {
            dfs(target - candidates[i], arrayListOf(candidates[i]), i + 1)
        }
        return result.distinct()
    }
}