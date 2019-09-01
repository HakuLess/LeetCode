package leetcode.contest.cur.c152

import leetcode.contest.utils.print
import java.util.ArrayList


fun main(args: Array<String>) {
    val s = Solution5185()
    s.canMakePaliQueries("abcda",
            arrayOf(
                    intArrayOf(3, 3, 0),
                    intArrayOf(1, 2, 0),
                    intArrayOf(0, 3, 1),
                    intArrayOf(0, 3, 2),
                    intArrayOf(0, 4, 1)
            )).print()
}

class Solution5185 {
    fun canMakePaliQueries(s: String, queries: Array<IntArray>): BooleanArray {
        val ans = ArrayList<Boolean>()
        val cnt = Array(s.length + 1) { IntArray(26) }
        for (i in 0 until s.length) {
            cnt[i + 1] = cnt[i].clone()
            ++cnt[i + 1][s[i] - 'a']
        }
        for (q in queries) {
            var sum = 0
            for (i in 0..25) {
                sum += (cnt[q[1] + 1][i] - cnt[q[0]][i]) % 2
            }
            ans.add(sum / 2 <= q[2])
        }
        return ans.toBooleanArray()
    }
}