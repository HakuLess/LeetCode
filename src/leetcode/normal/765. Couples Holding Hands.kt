package leetcode.normal

import leetcode.contest.utils.TypedUFS
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val a = Solution765()
    a.minSwapsCouples(
//            intArrayOf(0, 2, 1, 3)
            intArrayOf(3, 2, 0, 1)
    ).print()
}

class Solution765 {
    fun minSwapsCouples(row: IntArray): Int {
        val n = row.size
        val ufs = TypedUFS<Int>(n)
        for (i in row.indices step 2) {
            ufs.union(row[i] / 2, row[i + 1] / 2)
        }
        return n - ufs.getCount()
    }

//    fun minSwapsCouples(row: IntArray): Int {
//        fun swap(row: IntArray, a: Int, b: Int) {
//            val temp = row[a]
//            row[a] = row[b]
//            row[b] = temp
//        }
//        var ans = 0
//        for (i in 0 until row.size - 1 step 2) {
//            if (row[i] / 2 == row[i + 1] / 2) {
//                continue
//            } else {
//                val index = if (row[i] % 2 == 0) {
//                    row.indexOf(row[i] + 1)
//                } else {
//                    row.indexOf(row[i] - 1)
//                }
//                swap(row, i + 1, index)
//                ans++
//            }
//        }
//        return ans
//    }
}