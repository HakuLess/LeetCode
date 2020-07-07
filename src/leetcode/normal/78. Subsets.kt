package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    subsets(intArrayOf(1, 2, 3)).print()
}

fun subsets(nums: IntArray): List<List<Int>> {
    val result = arrayListOf<ArrayList<Int>>()
    result.add(arrayListOf())
    for (element in nums) {
        val temp = ArrayList(result)
        for (j in 0 until temp.size) {
            temp[j] = ArrayList(temp[j])
        }
        temp.forEach {
            it.add(element)
        }
        result.addAll(temp)
    }
    return result
}

