package leetcode.contest.cur.leetcode.c218

import leetcode.contest.utils.print
import java.util.*
import kotlin.system.measureTimeMillis


fun main(args: Array<String>) {
    val s = Solution5619()
//    s.minimumIncompatibility(intArrayOf(1, 2, 1, 4), 2).print()
    s.minimumIncompatibility(intArrayOf(6, 3, 8, 1, 3, 1, 2, 2), 4).print()
//    s.minimumIncompatibility(intArrayOf(10, 5, 6, 5, 6, 3, 6, 4, 2, 3), 10).print()
//    s.minimumIncompatibility(intArrayOf(4, 10, 4, 7, 9, 10, 4, 6, 9, 10), 5).print()
    measureTimeMillis {
        //        s.minimumIncompatibility(intArrayOf(13, 4, 7, 3, 3, 1, 12, 9, 11, 10, 13, 3, 12, 7), 7).print()
//        s.minimumIncompatibility(intArrayOf(2, 8, 2, 9, 2, 8, 2, 9, 6, 8, 6, 8), 6).print()
        s.minimumIncompatibility(intArrayOf(11, 11, 3, 4, 2, 16, 14, 13, 6, 14, 2, 5, 10, 13, 5, 7), 8).print()
    }.also {
        it.print()
    }
}

class Solution5619 {

    fun minimumIncompatibility(nums: IntArray, k: Int): Int {
        var ans = Int.MAX_VALUE
        val sets: Array<TreeSet<Int>> = Array<TreeSet<Int>>(k) { TreeSet() }
        for (i in 0 until k) {
            sets[i] = TreeSet()
        }
        fun dfs(index: Int, nums: IntArray, sets: Array<TreeSet<Int>>) {
            if (index == nums.size) {
                var sum = 0
                for (set in sets) {
                    sum += set.last() - set.first()
                }
                ans = minOf(ans, sum)
                return
            }
            for (set in sets) {
                if (set.size < nums.size / sets.size && !set.contains(nums[index])) {
                    set.add(nums[index])
                    dfs(index + 1, nums, sets)
                    set.remove(nums[index])
                    if (set.isEmpty()) break
                }
            }
        }
        dfs(0, nums, sets)
        return if (ans == Int.MAX_VALUE) -1 else ans
    }


//    fun minimumIncompatibility(nums: IntArray, k: Int): Int {
//        val t = nums.size / k
//        val cur = IntArray(nums.size) { -1 }
//        var ans = Int.MAX_VALUE
//
//        if (k == nums.size) return 0
//        val m = HashMap<Int, Int>()
//        nums.forEach {
//            m[it] = m.getOrDefault(it, 0) + 1
//        }
//        if (m.any { it.value > k }) return -1
//        fun dfs(cur: IntArray, index: Int, map: HashMap<Int, ArrayList<Int>>): Int {
//            var ans = Int.MAX_VALUE
//            for (i in 0 until k) {
//                if (cur.count { it == i } > t) {
//                    return Int.MAX_VALUE
//                }
//            }
//            if (index == cur.size) {
//                var res = 0
//                map.forEach {
//                    res += it.value.max()!! - it.value.min()!!
//                }
//                ans = minOf(ans, res)
//                return ans
//            }
//            for (i in 0 until k) {
//                cur[index] = i
//                if (map[i]!!.contains(nums[index])) continue
//                map[i]!!.add(nums[index])
//                ans = minOf(ans, dfs(cur.clone(), index + 1, map))
//                map[i]!!.remove(nums[index])
//                if (map[i]!!.isEmpty()) break
//            }
//            return ans
//        }
//
//        val s = HashMap<Int, ArrayList<Int>>()
//        for (i in 0 until k) {
//            s[i] = arrayListOf<Int>()
//        }
//        ans = dfs(cur, 0, s)
//        return if (ans == Int.MAX_VALUE) -1 else ans
//}
}