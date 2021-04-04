package leetcode.contest.cur.leetcode.c235

import leetcode.contest.utils.gcd
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5725()
    s.countDifferentSubsequenceGCDs(intArrayOf(3, 6, 10)).print()
}

class Solution5725 {
    fun countDifferentSubsequenceGCDs(nums: IntArray): Int {
        val seen = BooleanArray(200001) { false }
        nums.forEach { seen[it] = true }
        var ans = 0
        for (i in 1..200000) {
            var cur = -1
            for (j in i..200000 step i) {
                if (seen[j]) {
                    cur = if (cur == -1) j else gcd(cur, j)
                    if (cur == i) {
                        ans++
                        break
                    }
                }
            }
        }
        return ans
    }

//    fun countDifferentSubsequenceGCDs(nums: IntArray): Int {
//        val freq = HashMap<Int, Int>()
//        val subsets = HashMap<Int, Int>()
//        var arrMax = 0
//        for (i in nums.indices) {
//            arrMax = maxOf(arrMax, nums[i])
//            freq[nums[i]] = freq.getOrDefault(nums[i], 0) + 1
//        }
//        for (i in arrMax downTo 1) {
//            var sub = 0
//            var add = freq.getOrDefault(i, 0)
//            var j = 2
//            while (j * i <= arrMax) {
//                add += freq.getOrDefault(j * i, 0)
//                sub += subsets.getOrDefault(j * i, 0)
//                j++
//            }
//            subsets[i] = (1 shl add) - 1 - sub
//        }
//        return subsets.filter { it.value != 0 }.size
//    }
}