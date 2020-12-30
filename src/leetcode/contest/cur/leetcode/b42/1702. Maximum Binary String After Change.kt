package leetcode.contest.cur.leetcode.b42


class Solution1702 {
    fun maximumBinaryString(binary: String): String {
        if (binary.all { it == '1' }) return binary
        val n = binary.length
        var meet = false
        var r = 0
        for (i in binary.indices) {
            if (binary[i] == '0') {
                meet = true
            } else if (binary[i] == '1' && meet) {
                r++
            }
        }
        val ans = CharArray(n) { '1' }
        ans[n - r - 1] = '0'
        return ans.joinToString("")
    }
}