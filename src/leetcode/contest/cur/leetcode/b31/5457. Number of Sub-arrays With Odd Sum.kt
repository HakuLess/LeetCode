package leetcode.contest.cur.leetcode.b31

class Solution5457 {
    fun numOfSubarrays(arr: IntArray): Int {
        val mod = 1000000007L

        val tmp = longArrayOf(1, 0)
        var ans = 0L
        var cur = 0

        for (i in arr.indices) {
            cur = ((cur + arr[i]) % 2 + 2) % 2;
            tmp[cur]++
        }
        ans = tmp[0] * tmp[1]

        return (ans % mod).toInt()
    }
}