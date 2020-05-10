package leetcode.contest.last.b22

import leetcode.contest.utils.print


fun main(args: Array<String>) {
    val s = Solution5351()
    s.maxSizeSlices(intArrayOf(1, 2, 3, 4, 5, 6)).print()
//    s.maxSizeSlices(intArrayOf(3, 9, 4, 5, 3, 8, 1, 10, 3, 7, 2, 9, 10, 2, 6, 2, 9, 8, 7, 10, 7, 5, 1, 6, 5, 8, 9, 10, 6, 5, 7, 7, 2, 5, 3, 10, 4, 3, 4)).print()
}

class Solution5351 {

    fun maxSizeSlices(slices: IntArray): Int {
        return maxOf(helper(slices.copyOfRange(1, slices.size)),
                helper(slices.copyOfRange(0, slices.size - 1)))
    }

    private fun helper(slices: IntArray): Int {
        val dp = Array(slices.size / 3 + 1) { IntArray(slices.size) }
        for (i in dp.indices) {
            for (j in slices.indices) {
                dp[i][j] = maxOf(dp[i][j],
                        maxOf(slices[j] + if (i < 1 || j < 2) 0 else dp[i - 1][j - 2],
                                if (j == 0) 0 else dp[i][j - 1]))
            }
        }
        return dp[dp.lastIndex][slices.lastIndex]
    }

//    val seen = HashMap<String, Int>()
//
//    fun maxSizeSlices(slices: IntArray): Int {
//        val ans = helper(slices)
////        seen.print()
//        return ans
//    }
//
//    private fun helper(slices: IntArray): Int {
////        println(slices.joinToString(","))
//        if (slices.joinToString(",") in seen) {
//            return seen[slices.joinToString(",")]!!
//        }
//
//        var ans = 0
//
//        if (slices.size == 3) {
//            ans = slices.max()!!
//            seen[slices.joinToString(",")] = ans
//            return ans
//        }
//
//        val s = slices.toArrayList()
//        val cmp = getCmp(s)
//
//        for (i in slices.indices) {
//            if (slices[i] !in cmp) {
//                continue
//            }
//            val s = getSlices(i, slices)
//            ans = maxOf(ans, helper(s) + slices[i])
//        }
//        seen[slices.joinToString(",")] = ans
//        return ans
//    }
//
//    private fun getCmp(a: ArrayList<Int>): IntArray {
//        a.sortDescending()
//        return intArrayOf(a[0], a[1], a[2])
//    }
//
//    private fun getSlices(i: Int, slices: IntArray): IntArray {
//        val s = slices.toArrayList()
//        s.removeAt(i)
//        if (i in s.indices) {
//            s.removeAt(i)
//        } else {
//            s.removeAt(0)
//        }
//        if (i - 1 in s.indices) {
//            s.removeAt(i - 1)
//        } else
//            s.removeAt(s.lastIndex)
//
//        return s.toIntArray()
//    }
}