package leetcode.contest.cur.leetcode.b31

class Solution5458 {
    fun numSplits(s: String): Int {
        val a = HashMap<Char, Int>()
        val b = HashMap<Char, Int>()
        s.toCharArray().forEach {
            a[it] = a.getOrDefault(it, 0) + 1
        }

        var ans = 0
        s.forEach {
            a[it] = a[it]!! - 1
            b[it] = b.getOrDefault(it, 0) + 1
            if (a.count { it.value != 0 } == b.count { it.value != 0 }) {
                ans++
            }
        }
        return ans
    }
}