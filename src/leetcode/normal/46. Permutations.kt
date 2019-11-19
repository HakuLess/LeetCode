package leetcode.normal

import leetcode.contest.utils.print
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solution46()
    s.permute(intArrayOf(1, 1, 2)).print()
}

class Solution46 {
    fun permute(nums: IntArray): List<List<Int>> {
        val res = ArrayList<List<Int>>()
        val visited = IntArray(nums.size)
        backtrack(res, nums, ArrayList(), visited)
        return res
    }

    private fun backtrack(res: MutableList<List<Int>>, nums: IntArray, tmp: ArrayList<Int>, visited: IntArray) {
        if (tmp.size == nums.size) {
            res.add(ArrayList(tmp))
            return
        }
        for (i in nums.indices) {
            if (visited[i] == 1) continue
            visited[i] = 1
            tmp.add(nums[i])
            backtrack(res, nums, tmp, visited)
            visited[i] = 0
            tmp.removeAt(tmp.size - 1)
        }
    }

//    fun permute(nums: IntArray): List<List<Int>> {
//        val result = arrayListOf<ArrayList<Int>>()
//        var listStack: ArrayList<ArrayList<Int>>
//        nums.forEach {
//            listStack = ArrayList(result)
//            result.clear()
//            if (listStack.isEmpty()) {
//                result.add(arrayListOf(it))
//            } else {
//                while (listStack.isNotEmpty()) {
//                    val list = listStack.first()
//                    listStack.removeAt(0)
//                    for (i in 0..list.size) {
//                        val temp = ArrayList(list)
//                        temp.add(i, it)
//                        result.add(temp)
//                    }
//                }
//            }
//        }
//        return result.distinct()
//}
}