package leetcode.contest.cur.c158

import java.util.TreeMap
import java.util.HashMap



class Solution5225 {

    fun maxEqualFreq(nums: IntArray): Int {
        val m = HashMap<Int, Int>()
        val m2 = TreeMap<Int, Int>()
        for (n in nums)
            m[n] = m.getOrDefault(n, 0) + 1
        for (n in m.keys)
            m2[m[n]!!] = m2.getOrDefault(m[n], 0) + 1

        for (i in nums.indices.reversed()) {
            if (m2.size == 1) {
                val j = m2.firstKey()
                if (m2[j]!! > 1 && j == 1 || j > 1 && m2[j] == 1) {
                    return i + 1
                }
            }
            if (m2.size == 2) {
                val j = m2.firstKey()
                val k = m2.lastKey()
                if (m2[j] == 1 && j == 1)
                    return i + 1
                if (m2[k] == 1 && k - j == 1)
                    return i + 1
            }
            m2[m[nums[i]]!!] = m2[m[nums[i]]] - 1
            if (m2[m[nums[i]]] == 0)
                m2.remove(m[nums[i]])
            m[nums[i]] = m[nums[i]]!! - 1
            if (m[nums[i]]!! > 0)
                m2[m[nums[i]]!!] = m2.getOrDefault(m[nums[i]], 0) + 1
        }
        return 0
    }
//    fun maxEqualFreq(nums: IntArray): Int {
//        var ans = 1
//        val map = HashMap<Int, Int>()
//        for (i in nums.indices) {
//            map[nums[i]] = map.getOrDefault(nums[i], 0) + 1
//            if (checkMap(map)) {
//                ans = i
//            }
//        }
//        return ans + 1
//    }
//
//    private fun checkMap(map: HashMap<Int, Int>): Boolean {
//        val a = intArrayOf(-1, -1)
//        map.forEach {
//            if (a[0] == -1) {
//                a[0] = it.value
//            } else {
//                if (a[1] == -1 && a[0] != it.value) {
//                    a[1] = it.value
//                    if (abs(a[1] - a[0]) != 1 && a[0] != 0 && a[1] != 0) {
//                        return false
//                    }
//                }
//            }
//
//            if (it.value != a[0] && it.value != a[1]) {
//                return false
//            }
//            if (a[0] == -1 || a[1] == -1) {
//                return false
//            }
//        }
//        return true
//    }
}