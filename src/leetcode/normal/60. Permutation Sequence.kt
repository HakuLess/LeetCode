package leetcode.normal

import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    val s = Solution60()
    s.getPermutation(3, 3).print()
    s.getPermutation(4, 9).print()
}

class Solution60 {
    fun getPermutation(n: Int, k: Int): String {
        val sb = StringBuilder()
        val factor = intArrayOf(1, 1, 2, 6, 24, 120, 720, 5040, 40320)
        val list = LinkedList<Int>()
        for (i in 1..9) {
            list.add(i)
        }
        var last = k
        for (i in n downTo 1) {
            var index = last / factor[i - 1]
            last %= factor[i - 1]
            index = if (last > 0) index + 1 else index
            if (last == 0)
                last = factor[i - 1]
            sb.append(list.removeAt(index - 1))
        }
        return sb.toString()
    }

//    fun getPermutation(n: Int, k: Int): String {
//        val nums = IntArray(n) { i -> i + 1 }
//        var step = 1
//        while (step != k) {
//            nextPermutation(nums)
//            step++
//        }
//        return nums.joinToString("")
//    }
//
//    private fun nextPermutation(nums: IntArray) {
//        for (i in nums.size - 2 downTo 0) {
//            for (j in nums.size - 1 downTo i + 1) {
//                if (nums[j] > nums[i]) {
//                    val temp = nums[i]
//                    nums[i] = nums[j]
//                    nums[j] = temp
//                    nums.sort(i + 1, nums.size)
//                    return
//                }
//            }
//        }
//        nums.reverse()
//    }
}