package leetcode.normal

import java.util.*
import kotlin.collections.ArrayList


fun main(args: Array<String>) {
    val s = Solution969()
    s.pancakeSort(intArrayOf(3, 2, 4, 1)).forEach {
        print("$it, ")
    }
}

class Solution969 {
    fun pancakeSort(arr: IntArray): List<Int> {
        val cur = ArrayList<Int>()
        cur.addAll(arr.toList())
        val ans = arrayListOf<Int>()
        var end = cur.lastIndex
        while (end >= 0) {
            if (cur[end] == cur.size) {
                end--
                cur.removeAt(cur.lastIndex)
            } else {
                val maxIndex = cur.indexOf(cur.maxOrNull())
                ans.add(maxIndex + 1)
                ans.add(cur.size)
                cur.subList(0, maxIndex + 1).reverse()
                cur.reverse()
            }
        }
        return ans
    }
}