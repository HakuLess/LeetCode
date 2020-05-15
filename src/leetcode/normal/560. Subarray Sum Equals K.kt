package leetcode.normal

import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    val s = Solution560()
    s.subarraySum(intArrayOf(1, 1, 1), 2).print()
}

class Solution560 {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        var pre = 0
        val mp = HashMap<Int, Int>()
        mp[0] = 1
        for (i in nums.indices) {
            pre += nums[i]
            if (mp.containsKey(pre - k))
                count += mp[pre - k]!!
            mp[pre] = mp.getOrDefault(pre, 0) + 1
        }
        return count
    }

//    fun subarraySum(nums: IntArray, k: Int): Int {
//        var ans = 0
//        for (i in nums.indices) {
//            var sum = 0
//            for (j in i until nums.size) {
//                sum += nums[j]
//                if (sum == k) {
//                    ans++
//                }
//            }
//        }
//        return ans
//    }
//    fun subarraySum(nums: IntArray, k: Int): Int {
//        var cur = 0
//        var start = 0
//        var ans = 0
//        for (i in nums.indices) {
//            cur += nums[i]
//            if (cur == k) {
//                ans++
//            }
//            if (cur >= k) {
//                cur -= nums[start]
//                start++
//            }
//        }
//        return ans
//    }
}