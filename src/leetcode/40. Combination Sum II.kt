package leetcode

fun main(args: Array<String>) {
    val s = Solution40()
    s.combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8).print()
}

class Solution40 {
    val result = arrayListOf<ArrayList<Int>>()

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
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