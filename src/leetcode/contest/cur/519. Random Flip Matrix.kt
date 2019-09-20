package leetcode.contest.cur

class Solution(n_rows: Int, n_cols: Int) {
    private val n = n_rows
    private val m = n_cols
    private val cur = HashSet<Int>()

    fun flip(): IntArray {
        var f = (Math.random() * ((m * n) - cur.size)).toInt()
        while (cur.contains(f)) {
            f++
            f %= (m * n)
        }
        println(cur)
        cur.add(f)
        return intArrayOf(f % n, f / n)
    }

    fun reset() {
        cur.clear()
    }

}