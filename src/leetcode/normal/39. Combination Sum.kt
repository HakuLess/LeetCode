package leetcode.normal

class Solution39 {

    val ans = arrayListOf<ArrayList<Int>>()

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        fillAns(candidates, target, arrayListOf(), 0)
        return ans
    }

    private fun fillAns(candidates: IntArray, target: Int, current: ArrayList<Int>, start: Int) {
        if (target < 0) {
            return
        }
        if (target == 0) {
            ans.add(current)
        }
        for (i in start..candidates.lastIndex) {
            val next = ArrayList(current)
            next.add(candidates[i])
            fillAns(candidates, target - candidates[i], next, i)
        }
    }
}