package leetcode.normal

class Solution39 {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val ans = arrayListOf<ArrayList<Int>>()
        fun dfs(target: Int, current: ArrayList<Int>, start: Int) {
            if (target < 0) {
                return
            }
            if (target == 0) {
                ans.add(current)
            }
            for (i in start..candidates.lastIndex) {
                val next = ArrayList(current)
                next.add(candidates[i])
                dfs(target - candidates[i], next, i)
            }
        }
        dfs(target, arrayListOf(), 0)
        return ans
    }
}