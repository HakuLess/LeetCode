package leetcode


class Solution697 {

    fun findShortestSubArray(nums: IntArray): Int {
        val left = hashMapOf<Int, Int>()
        val right = hashMapOf<Int, Int>()
        val count = hashMapOf<Int, Int>()

        for (i in nums.indices) {
            val x = nums[i]
            if (left[x] == null) {
                left[x] = i
            }
            right[x] = i
            count[x] = count.getOrDefault(x, 0) + 1
        }

        var ans = nums.size
        val degree = count.values.max()
        for (x in count.keys) {
            if (count[x] == degree) {
                ans = Math.min(ans, right[x]!! - left[x]!! + 1)
            }
        }
        return ans
    }

//    fun findShortestSubArray(nums: IntArray): Int {
//        val array = IntArray(50000)
//        nums.forEach {
//            array[it]++
//        }
//
//        val list = arrayListOf<Int>()
//        var temp = 0
//        for (i in 0 until array.size) {
//            if (array[i] > temp) {
//                list.clear()
//                list.add(i)
//                temp = array[i]
//            } else if (array[i] == temp) {
//                list.add(i)
//            }
//        }
//
//        var ans = Int.MAX_VALUE
//        list.forEach {
//            ans = minOf(nums.lastIndexOf(it) - nums.indexOf(it), ans)
//        }
//
//        return ans + 1
//    }
}