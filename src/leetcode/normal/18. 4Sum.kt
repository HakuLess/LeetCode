package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution18()
    s.fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0).print()
}

class Solution18 {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = hashSetOf<List<Int>>()
        val sorted = nums.sorted().toIntArray()

        sorted.forEachIndexed { index, i ->
            val threeResult = threeSum(sorted.copyOfRange(0, index).plus(sorted.copyOfRange(index + 1, sorted.size)), target - i)
            threeResult.forEach {
                result.add(arrayListOf(i).asSequence().plus(it).sorted().toList())
            }
        }

        return result.toMutableList()
    }

    private fun threeSum(sorted: IntArray, target: Int): List<List<Int>> {
        val result = hashSetOf<List<Int>>()
        sorted.forEachIndexed { index, value ->
            var left = index + 1
            var right = sorted.size - 1
            while (left < right) {
                when {
                    sorted[left] + sorted[right] < target - value -> left++
                    sorted[left] + sorted[right] == target - value -> {
                        result.add(arrayListOf(sorted[left], sorted[right], value).sorted())
                        left++
                        right--
                    }
                    else -> right--
                }
            }
        }
        return result.toMutableList()
    }
}
