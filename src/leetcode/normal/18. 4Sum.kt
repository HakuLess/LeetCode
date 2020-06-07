package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution18()
    s.fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0).print()
}

class Solution18 {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        if (nums.size < 4) return emptyList()
        val ans = ArrayList<List<Int>>()
        nums.sort()
        val temp = nums[nums.lastIndex - 2] + nums[nums.lastIndex - 1] + nums.last()
        for (i in 0..nums.size - 4) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break
            if (i > 0 && nums[i] == nums[i - 1]) continue
            if (nums[i] + temp < target) continue
            for (j in i + 1..nums.size - 3) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue
                var l = j + 1
                var r = nums.lastIndex
                while (l < r) {
                    val sum = nums[i] + nums[j] + nums[l] + nums[r]
                    when {
                        sum == target -> {
                            ans.add(listOf(nums[i], nums[j], nums[l++], nums[r--]))
                            while (l < r && nums[l] == nums[l - 1]) l++
                            while (l < r && nums[r] == nums[r + 1]) r--
                        }
                        sum < target -> l++
                        else -> r--
                    }
                }
            }
        }
        return ans
    }

//    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
//        val result = hashSetOf<List<Int>>()
//        val sorted = nums.sorted().toIntArray()
//
//        sorted.forEachIndexed { index, i ->
//            val threeResult = threeSum(sorted.copyOfRange(0, index).plus(sorted.copyOfRange(index + 1, sorted.size)), target - i)
//            threeResult.forEach {
//                result.add(arrayListOf(i).asSequence().plus(it).sorted().toList())
//            }
//        }
//
//        return result.toMutableList()
//    }
//
//    private fun threeSum(sorted: IntArray, target: Int): List<List<Int>> {
//        val result = hashSetOf<List<Int>>()
//        sorted.forEachIndexed { index, value ->
//            var left = index + 1
//            var right = sorted.size - 1
//            while (left < right) {
//                when {
//                    sorted[left] + sorted[right] < target - value -> left++
//                    sorted[left] + sorted[right] == target - value -> {
//                        result.add(arrayListOf(sorted[left], sorted[right], value).sorted())
//                        left++
//                        right--
//                    }
//                    else -> right--
//                }
//            }
//        }
//        return result.toMutableList()
//    }
}
