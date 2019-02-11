package leetcode

import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    permute(intArrayOf(1, 1, 2)).print()
}

fun permute(nums: IntArray): List<List<Int>> {
    val result = arrayListOf<ArrayList<Int>>()
    var listStack: ArrayList<ArrayList<Int>>
    nums.forEach {
        listStack = ArrayList(result)
        result.clear()
        if (listStack.isEmpty()) {
            result.add(arrayListOf(it))
        } else {
            while (listStack.isNotEmpty()) {
                val list = listStack.first()
                listStack.removeAt(0)
                for (i in 0..list.size) {
                    val temp = ArrayList(list)
                    temp.add(i, it)
                    result.add(temp)
                }
            }
        }
    }
    return result.distinct()
}