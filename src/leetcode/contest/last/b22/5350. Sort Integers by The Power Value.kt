package leetcode.contest.last.b22

class Solution5350 {
    fun getKth(lo: Int, hi: Int, k: Int): Int {
        val list = arrayListOf<Int>()
        for (i in lo..hi) {
            list.add(i)
        }
        val seen = HashMap<Int, Int>()
        seen[1] = 0
        fun getP(it: Int): Int {
            if (it in seen) {
                return seen[it]!!
            }
            return if (it % 2 == 0) {
                getP(it / 2) + 1
            } else {
                getP(3 * it + 1) + 1
            }.also { ans ->
                seen[it] = ans
            }
        }
        return list.sortedBy {
            getP(it)
        }[k - 1]
    }
}