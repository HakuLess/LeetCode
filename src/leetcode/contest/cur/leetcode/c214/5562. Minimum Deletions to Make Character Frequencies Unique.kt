package leetcode.contest.cur.leetcode.c214

class Solution5562 {
    fun minDeletions(s: String): Int {
        val c = IntArray(26)
        s.forEach {
            c[it - 'a']++
        }
        var ans = 0
        val set = HashSet<Int>()
        c.forEach {
            if (it != 0) {
                if (it !in set) {
                    set.add(it)
                } else {
                    var tmp = it
                    while (tmp in set) {
                        tmp--
                    }
                    set.add(tmp)
                    ans += if (tmp <= 0) {
                        it
                    } else {
                        it - tmp
                    }
                }
            }
        }
        return ans
    }
}