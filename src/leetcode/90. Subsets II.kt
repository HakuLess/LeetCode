package leetcode

class Solution90 {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = arrayListOf<ArrayList<Int>>()
        result.add(arrayListOf())

        for (i in 0 until nums.size) {
            val temp = ArrayList(result)
            for (j in 0 until temp.size) {
                temp[j] = ArrayList(temp[j])
            }
            temp.forEach {
                it.add(nums[i])
            }
            result.addAll(temp)
        }
        return result.distinct()
    }
}