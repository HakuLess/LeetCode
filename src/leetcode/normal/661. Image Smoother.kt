package leetcode.normal

class Solution661 {
    fun imageSmoother(M: Array<IntArray>): Array<IntArray> {
        if (M.isEmpty() || M[0].isEmpty()) {
            return emptyArray()
        }

        val ans = Array(M.size) { IntArray(M[0].size) }
        for (i in 0 until M.size) {
            for (j in 0 until M[0].size) {
                ans[i][j] = getPoint(M, i, j)
            }
        }
        return ans
    }

    private fun getPoint(M: Array<IntArray>, i: Int, j: Int): Int {
        val ans = getOrigin(M, i - 1, j).second +
                getOrigin(M, i + 1, j).second +
                getOrigin(M, i, j - 1).second +
                getOrigin(M, i, j + 1).second +
                getOrigin(M, i - 1, j - 1).second +
                getOrigin(M, i + 1, j + 1).second +
                getOrigin(M, i - 1, j + 1).second +
                getOrigin(M, i + 1, j - 1).second +
                getOrigin(M, i, j).second

        val count = getOrigin(M, i - 1, j).first +
                getOrigin(M, i + 1, j).first +
                getOrigin(M, i, j - 1).first +
                getOrigin(M, i, j + 1).first +
                getOrigin(M, i - 1, j - 1).first +
                getOrigin(M, i + 1, j + 1).first +
                getOrigin(M, i - 1, j + 1).first +
                getOrigin(M, i + 1, j - 1).first +
                getOrigin(M, i, j).first
        return ans / count
    }

    private fun getOrigin(M: Array<IntArray>, i: Int, j: Int): Pair<Int, Int> {
        return if (i in 0 until M.size && j in 0 until M[0].size) {
            Pair(1, M[i][j])
        } else {
            Pair(0, 0)
        }
    }
}