package leetcode.normal

class Solution260 {
    fun singleNumber(nums: IntArray): IntArray {
        val map = hashMapOf<Int, Int>()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        val ans = arrayListOf<Int>()
        map.forEach { (t, u) ->
            if (u == 1) {
                ans.add(t)
            }
        }
        return ans.toIntArray()
    }
}