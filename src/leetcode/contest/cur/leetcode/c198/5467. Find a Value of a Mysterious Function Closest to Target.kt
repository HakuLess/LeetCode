package leetcode.contest.cur.leetcode.c198

import leetcode.contest.utils.SegmentTree
import leetcode.contest.utils.print
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5467()
    s.closestToTarget(intArrayOf(9, 12, 3, 7, 15), 5).print()
}

class Solution5467 {
    fun closestToTarget(arr: IntArray, target: Int): Int {
        var ans = Int.MAX_VALUE / 2
        val root = SegmentTree<Int> { a, b ->
            a and b
        }.build(arr.toTypedArray())!!
        var l = 0
        var r = 0
        while (r < arr.size) {
            val cur = root.query(root, l, r)
            when {
                cur < target -> {
                    l++
                    r = maxOf(r, l)
                }
                cur > target -> {
                    r++
                }
                else -> {
                    return 0
                }
            }
            ans = minOf(ans, abs(target - cur))
        }
        return ans
    }

//    fun closestToTarget(arr: IntArray, target: Int): Int {
//        var s = hashSetOf<Int>()
//        var ans = Int.MAX_VALUE / 2
//        for (i in arr.indices) {
//            val ns = hashSetOf<Int>()
//            ns.add(arr[i])
//            s.forEach {
//                ns.add(it and arr[i])
//            }
//            ns.forEach {
//                ans = minOf(ans, abs(it - target))
//            }
//            s = ns
//        }
//        return ans
//    }
}