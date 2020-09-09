package leetcode.normal

class Solution661 {
    fun imageSmoother(M: Array<IntArray>): Array<IntArray> {
        if (M.isEmpty()) {
            return M
        }
        val m = M.size
        val n = M[0].size
        val res = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                var count = 0
                var sum = 0
                for (x in i - 1..i + 1) {
                    for (y in j - 1..j + 1) {
                        if (x in 0 until m && y in 0 until n) {
                            count++
                            sum += M[x][y]
                        }
                    }
                }
                res[i][j] = sum / count
            }
        }
        return res
    }
}