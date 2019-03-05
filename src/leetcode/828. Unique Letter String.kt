package leetcode


//todo study
class Solution828 {
    fun uniqueLetterString(S: String): Int {
        val index = Array(26) { IntArray(2) { -1 } }
        var res = 0
        val n = S.length
        val mod = Math.pow(10.0, 9.0).toInt() + 7

        for (i in 0 until n) {
            val c = S[i] - 'A'
            res = (res + (i - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod
            index[c] = intArrayOf(index[c][1], i)
        }

        for (c in 0..25) {
            res = (res + (n - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod
        }
        return res
    }
}