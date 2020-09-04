package leetcode.normal

import java.util.*

class Solution898 {
    fun subarrayBitwiseORs(A: IntArray): Int {
        val ans = HashSet<Int>()
        var cur = HashSet<Int>()
        cur.add(0)
        for (x in A) {
            val cur2 = HashSet<Int>()
            for (y in cur) cur2.add(x or y)
            cur2.add(x)
            cur = cur2
            ans.addAll(cur)
        }
        return ans.size
    }
}
