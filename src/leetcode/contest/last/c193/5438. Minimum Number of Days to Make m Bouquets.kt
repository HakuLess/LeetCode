package leetcode.contest.last.c193

class Solution5438 {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        fun check(day: Int): Boolean {
            var cur = 0
            var ans = 0
            for (i in bloomDay.indices) {
                if (bloomDay[i] <= day) {
                    cur++
                    if (cur == k) {
                        ans++
                        cur = 0
                        if (ans == m) {
                            return true
                        }
                    }
                } else {
                    cur = 0
                }
            }
            return false
        }

        var left = bloomDay.min()!!
        var right = bloomDay.max()!!
        while (left + 1 < right) {
            val mid = (left + right).ushr(1)
            when {
                (check(mid)) -> right = mid
                else -> left = mid
            }
        }
        return if (check(left)) {
            left
        } else {
            if (check(right)) {
                right
            } else {
                -1
            }
        }
    }
}