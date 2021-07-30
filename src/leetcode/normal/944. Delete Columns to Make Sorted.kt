package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution944()
    s.minDeletionSize(arrayOf("rrjk", "furt", "guzm")).print()
}

class Solution944 {
    fun minDeletionSize(strs: Array<String>): Int {
        val n = strs[0].length
        var ans = 0
        for (i in 0 until n) {
            var lst = 'a' - 1
            for (j in strs.indices) {
                if (strs[j][i] >= lst) {
                    lst = strs[j][i]
                } else {
                    println("${strs[j][i]} $lst")
                    ans++
                    break
                }
            }
        }
        return ans
    }
}