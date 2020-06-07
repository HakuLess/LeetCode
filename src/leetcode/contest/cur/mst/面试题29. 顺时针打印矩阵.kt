package leetcode.contest.cur.mst

class Solution29 {
    fun spiralOrder(matrix: Array<IntArray>): IntArray {
        val ans = arrayListOf<Int>()
        if (matrix.isEmpty()) return ans.toIntArray()
        val m = matrix.size
        val n = matrix[0].size
        val seen = Array(m) { BooleanArray(n) }
        val dr = intArrayOf(0, 1, 0, -1)
        val dc = intArrayOf(1, 0, -1, 0)
        var r = 0
        var c = 0
        var di = 0
        for (i in 0 until m * n) {
            ans.add(matrix[r][c])
            seen[r][c] = true
            val cr = r + dr[di]
            val cc = c + dc[di]
            if (cr in 0 until m && cc in 0 until n && !seen[cr][cc]) {
                r = cr
                c = cc
            } else {
                di = (di + 1) % 4
                r += dr[di]
                c += dc[di]
            }
        }
        return ans.toIntArray()
    }
}