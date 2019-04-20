package leetcode.normal

import leetcode.print
import java.util.TreeMap


fun main(args: Array<String>) {
    val s = Solution962()
    s.maxWidthRamp(intArrayOf(9, 8, 1, 0, 1, 9, 4, 0, 4, 1)).print()
}

class Solution962 {

    fun maxWidthRamp(A: IntArray): Int {
        val map = TreeMap<Int, Int>()
        var dist = 0
        for (i in A.indices) {
            if (map.floorKey(A[i]) == null)
                map[A[i]] = i
            else
                dist = maxOf(dist, i - map[map.floorKey(A[i])]!!)
        }
        return dist
    }

//    fun maxWidthRamp(A: IntArray): Int {
//        var ans = 0
////        val sort = arrayListOf<Int>()
//        val sort = TreeMap<Int, Int>()
//
//        A.forEachIndexed { index, int ->
//            if (sort.isEmpty()) {
//                sort[int] = index
//            } else {
//                if (int < A[sort.last()]) {
//                    sort.add(index)
//                } else {
//                    for (p in sort) {
//                        if (A[p] <= int) {
//                            ans = maxOf(ans, index - p)
//                            break
//                        }
//                    }
//                }
//            }
//        }
//        return ans
//    }
}