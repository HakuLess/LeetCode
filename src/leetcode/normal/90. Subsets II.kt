package leetcode.normal

fun main(args: Array<String>) {
}

class Solution90 {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = ArrayList<ArrayList<Int>>()
        res.add(arrayListOf())
        var start = 0
        for (i in nums.indices) {
            val count = res.size
            for (j in 0 until res.size) {
                if (nums.getOrNull(i - 1) == nums[i] && j < start) {
                    continue
                } else {
                    val item = ArrayList<Int>(res[j])
                    item.add(nums[i])
                    res.add(item)
                }
            }
            start = count
        }
        return res
    }
//    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
//        nums.sort()
//        val result = arrayListOf<ArrayList<Int>>()
//        result.add(arrayListOf())
//
//        for (element in nums) {
//            val temp = ArrayList(result)
//            for (j in 0 until temp.size) {
//                temp[j] = ArrayList(temp[j])
//            }
//            temp.forEach {
//                it.add(element)
//            }
//            result.addAll(temp)
//        }
//        return result.distinct()
//    }
}