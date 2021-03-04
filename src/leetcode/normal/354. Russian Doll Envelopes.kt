package leetcode.normal

import leetcode.contest.utils.lis

class Solution354 {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        if (envelopes.isEmpty()) return 0
        envelopes.sortWith(compareBy({ it[0] }, { -it[1] }))
        return envelopes.map { it[1] }.toIntArray().lis()
    }
}