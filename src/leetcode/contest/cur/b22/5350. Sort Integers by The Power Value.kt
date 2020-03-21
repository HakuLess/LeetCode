package leetcode.contest.cur.b22

fun main(args: Array<String>) {

}
class Solution5350 {
    val seen = HashMap<Int, Int>()

    fun getKth(lo: Int, hi: Int, k: Int): Int {
        val list = arrayListOf<Int>()
        for (i in lo..hi) {
            list.add(i)
        }
        seen[1] = 1
        return list.sortedBy {
            getP(it)
        }[k]
    }

    private fun getP(it: Int): Int {
        if (it in seen) {
            return seen[it]!!
        }
        val ans = if (it % 2 == 0) {
            getP(it / 2) + 1
        } else {
            getP(3 * it + 1) + 1
        }
        seen[it] = ans
        return ans
    }
}