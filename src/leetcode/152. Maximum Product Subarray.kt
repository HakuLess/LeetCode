package leetcode

class Solution152 {

    fun maxProduct(nums: IntArray): Int {
        var ans = nums[0]
        var min = ans
        var max = ans
        for (i in 1 until nums.size) {
            val c = nums[i]
            if (c >= 0) {
                min = Math.min(c, c * min)
                max = Math.max(c, c * max)
            } else {
                val temp = min
                min = Math.min(c, c * max)
                max = Math.max(c, c * temp)
            }
            ans = Math.max(ans, max)
        }
        return ans
    }
//
//    fun maxProduct(nums: IntArray): Int {
//        var ans = Int.MIN_VALUE
//        val data = arrayListOf<Int>()
//        var temp = 0
//        nums.forEach {
//            if (it != 0) {
//                data.add(it)
//            } else {
//                temp = maxProductWithOutZero(data.toIntArray())
//                ans = maxOf(ans, temp)
//                ans = maxOf(ans, 0)
//                data.clear()
//            }
//        }
//
//        temp = maxProductWithOutZero(data.toIntArray())
//        ans = maxOf(ans, temp)
//        return ans
//    }
//
//    private fun maxProductWithOutZero(nums: IntArray): Int {
//        if (nums.size == 1) {
//            return nums[0]
//        }
//        if (nums.isEmpty()) {
//            return 0
//        }
//        val minus = nums.count {
//            it < 0
//        }
//        var ans = 1
//        if (minus % 2 == 0) {
//            nums.forEach {
//                ans *= it
//            }
//        } else {
//            val first = nums.indexOfFirst { it < 0 }
//            val last = nums.indexOfLast { it < 0 }
//
//            var pre = 1
//            for (i in 0 until last) {
//                pre *= nums[i]
//            }
//
//            var suf = 1
//            for (i in first + 1 until nums.size) {
//                suf *= nums[i]
//            }
//
//            ans = maxOf(pre, suf)
//        }
//
//        return ans
//    }
}