package leetcode.contest.cur.leetcode.c241

class FindSumPairs(val nums1: IntArray, val nums2: IntArray) {

    private val map1 = HashMap<Int, Int>()
    private val map2 = HashMap<Int, Int>()

    init {
        nums1.forEach {
            map1[it] = map1.getOrDefault(it, 0) + 1
        }
        nums2.forEach {
            map2[it] = map2.getOrDefault(it, 0) + 1
        }
    }

    fun add(index: Int, `val`: Int) {
        map2[nums2[index]] = map2.getOrDefault(nums2[index], 0) - 1
        nums2[index] += `val`
        map2[nums2[index]] = map2.getOrDefault(nums2[index], 0) + 1
    }

    fun count(tot: Int): Int {
        var ans = 0
        map1.forEach { (v, c) ->
            ans += map2.getOrDefault(tot - v, 0) * c
        }
        return ans
    }

}