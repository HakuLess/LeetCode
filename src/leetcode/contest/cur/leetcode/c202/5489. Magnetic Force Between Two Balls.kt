package leetcode.contest.cur.leetcode.c202

class Solution5489 {
    fun maxDistance(position: IntArray, m: Int): Int {
        fun check(dis: Int): Int {
            var cur = -1
            var ans = 0
            position.forEach {
                if (cur == -1) {
                    cur = it
                    ans++
                } else if (it - cur >= dis) {
                    ans++
                    cur = it
                }
            }
            return ans
        }

        position.sort()
        var left = 1
        var right = position.last()
        while (left + 1 < right) {
            val mid = (left + right).ushr(1)
            when {
                (check(mid) < m) -> right = mid
                else -> left = mid
            }
        }
        return if ((check(right) == m)) {
            right
        } else {
            left
        }
    }
}