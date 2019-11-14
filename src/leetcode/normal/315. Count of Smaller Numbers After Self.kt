package leetcode.normal

import leetcode.contest.utils.print
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solution315()
    s.countSmaller(intArrayOf(5, 2, 6, 1)).toIntArray().print()
    s.countSmaller(intArrayOf(-1, -1)).toIntArray().print()
    s.countSmaller(intArrayOf(5, 2, 6, 5, 1)).toIntArray().print()
}

class Solution315 {
    fun countSmaller(nums: IntArray): List<Int> {
        val ans = ArrayList<Int>()
        val cur = ArrayList<Int>()
        for (it in nums.reversed()) {
            var pos = cur.binarySearch(it)
            if (pos >= 0) {
                while (pos != 0 && cur[pos - 1] == cur[pos]) {
                    pos--
                }
                ans.add(pos)
                cur.add(pos, it)
            } else {
                ans.add(-pos - 1)
                cur.add(-pos - 1, it)
            }
        }
        return ans.reversed()
    }

//    fun countSmaller(nums: IntArray): List<Int> {
//        val ans = ArrayList<Int>()
//        for (i in nums.indices) {
//            var temp = 0
//            for (j in i + 1..nums.lastIndex) {
//                if (nums[j] < nums[i]) {
//                    temp++
//                }
//            }
//            ans.add(temp)
//        }
//        return ans
//    }
}