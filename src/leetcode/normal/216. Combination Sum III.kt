package leetcode.normal


class Solution216 {

    val result = arrayListOf<ArrayList<Int>>()

    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val source = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        return combinationSum2(source, n).filter {
            it.size == k
        }
    }

    private fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        for (i in 0 until candidates.size) {
            fillAns(candidates, target - candidates[i], arrayListOf(candidates[i]), i + 1)
        }
        return result.distinct()
    }

    private fun fillAns(candidates: IntArray, target: Int, ans: ArrayList<Int>, startIndex: Int) {
        if (target == 0) {
            result.add(ans)
            return
        }

        if (target < 0 || startIndex >= candidates.size) {
            return
        }

        for (i in startIndex until candidates.size) {
            val temp = ArrayList(ans)
            temp.add(candidates[i])
            fillAns(candidates, target - candidates[i], temp, i + 1)
        }
    }
}