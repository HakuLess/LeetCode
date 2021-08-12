package leetcode.contest.cur.leetcode.c214

class Solution5561 {
    fun getMaximumGenerated(n: Int): Int {
        if (n == 0)
            return 0
        if (n == 1)
            return 1
        val arr = IntArray(n + 1)
        arr[1] = 1
        for (i in 2..n) {
            if (i % 2 == 0)
                arr[i] = arr[i / 2]
            else
                arr[i] = arr[i / 2] + arr[i / 2 + 1]
        }
        return arr.maxOrNull()!!
    }
}