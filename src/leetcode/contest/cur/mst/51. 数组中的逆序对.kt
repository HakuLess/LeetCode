package leetcode.contest.cur.mst

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solutionmst51()
    s.reversePairs(intArrayOf(7, 5, 6, 4)).print()
}

class Solutionmst51 {

    fun reversePairs(nums: IntArray): Int {
        val len = nums.size
        if (len < 2) {
            return 0
        }
        val copy = IntArray(len)
        for (i in 0 until len) {
            copy[i] = nums[i]
        }
        val temp = IntArray(len)
        return reversePairs(copy, 0, len - 1, temp)
    }

    private fun reversePairs(nums: IntArray, left: Int, right: Int, temp: IntArray): Int {
        if (left == right) {
            return 0
        }
        val mid = left + (right - left) / 2
        val leftPairs = reversePairs(nums, left, mid, temp)
        val rightPairs = reversePairs(nums, mid + 1, right, temp)
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs
        }
        val crossPairs = mergeAndCount(nums, left, mid, right, temp)
        return leftPairs + rightPairs + crossPairs
    }

    private fun mergeAndCount(nums: IntArray, left: Int, mid: Int, right: Int, temp: IntArray): Int {
        for (i in left..right) {
            temp[i] = nums[i]
        }
        var i = left
        var j = mid + 1
        var count = 0
        for (k in left..right) {
            when {
                i == mid + 1 -> {
                    nums[k] = temp[j]
                    j++
                }
                j == right + 1 -> {
                    nums[k] = temp[i]
                    i++
                }
                temp[i] <= temp[j] -> {
                    nums[k] = temp[i]
                    i++
                }
                else -> {
                    nums[k] = temp[j]
                    j++
                    count += mid - i + 1
                }
            }
        }
        return count
    }

//    fun reversePairs(nums: IntArray): Int {
//        var ans = 0
//        nums.forEachIndexed { i1, n1 ->
//            ans += nums.filterIndexed { i2, n2 ->
//                i2 > i1 && n1 > n2
//            }.count()
//        }
//        return ans
//    }
}