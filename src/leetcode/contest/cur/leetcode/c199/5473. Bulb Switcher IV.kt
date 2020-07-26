package leetcode.contest.cur.leetcode.c199

class Solution5473 {
    fun minFlips(target: String): Int {
        var cur = '0'
        var res = 0
        for (i in target.indices) {
            val l = target[i]
            if (l == cur) continue
            else {
                res++
                if (cur == '0') cur = '1' else cur = '0'
            }
        }
        return res
    }
}