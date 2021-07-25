package leetcode.contest.cur.leetcode.c251

class Solution5824 {
    fun maximumNumber(num: String, change: IntArray): String {
        var meet = false
        var end = false
        return num.map {
            if (end) {
                it.toString()
            } else {
                if (meet && change[it - '0'] >= it - '0') {
                    change[it - '0'].toString()
                } else if (meet && change[it - '0'] < it - '0') {
                    end = true
                    it.toString()
                } else if (change[it - '0'] > it - '0') {
                    meet = true
                    change[it - '0'].toString()
                } else {
                    it.toString()
                }
            }
        }.joinToString("")
    }
}