package leetcode

import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution949()
    s.largestTimeFromDigits(intArrayOf(1, 2, 3, 4)).print()
    s.largestTimeFromDigits(intArrayOf(5, 5, 5, 5)).print()
}

class Solution949 {
    fun largestTimeFromDigits(A: IntArray): String {
        val list = arrayListOf<Pair<Int, Int>>()
        permute(A).forEach {
            if (it[0] * 10 + it[1] in 0..23 && it[2] * 10 + it[3] in 0..59) {
                list.add(Pair(it[0] * 10 + it[1], it[2] * 10 + it[3]))
            }
        }

        if (list.isEmpty()) {
            return ""
        }
        list.sortWith(compareBy({ -it.first }, { -it.second }))
        val ans = StringBuilder()
        if (list[0].first < 10) {
            ans.append(0)
        }
        ans.append(list[0].first)
        ans.append(":")
        if (list[0].second < 10) {
            ans.append(0)
        }
        ans.append(list[0].second)
        return ans.toString()
    }

    private fun permute(nums: IntArray): List<List<Int>> {
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
}