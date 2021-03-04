package leetcode.normal

import leetcode.contest.utils.isSubsequence

class Solution522 {
    fun findLUSlength(strs: Array<String>): Int {
        strs.sortByDescending { it.length }
        for (i in strs.indices) {
            if (strs.count { isSubsequence(strs[i], it) } > 1) continue
            else return strs[i].length
        }
        return -1
    }
}