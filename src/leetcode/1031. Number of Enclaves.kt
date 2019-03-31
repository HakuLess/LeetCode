package leetcode

fun main(args: Array<String>) {
    val s = Solution1031()
    s.numEnclaves(
//            arrayOf(
//                    intArrayOf(0, 0, 0, 0),
//                    intArrayOf(1, 0, 1, 0),
//                    intArrayOf(0, 1, 1, 0),
//                    intArrayOf(0, 0, 0, 0)
//            )
//            arrayOf(
//                    intArrayOf(0, 1, 1, 0),
//                    intArrayOf(0, 0, 1, 0),
//                    intArrayOf(0, 1, 1, 0),
//                    intArrayOf(0, 0, 0, 0)
//            )
            arrayOf(
                    intArrayOf(0, 0, 0, 1, 1, 1, 0, 1, 0, 0),
                    intArrayOf(1, 1, 0, 0, 0, 1, 0, 1, 1, 1),
                    intArrayOf(0, 0, 0, 1, 1, 1, 0, 1, 0, 0),
                    intArrayOf(0, 1, 1, 0, 0, 0, 1, 0, 1, 0),
                    intArrayOf(0, 1, 1, 1, 1, 1, 0, 0, 1, 0),
                    intArrayOf(0, 0, 1, 0, 1, 1, 1, 1, 0, 1),
                    intArrayOf(0, 1, 1, 0, 0, 0, 1, 1, 1, 1),
                    intArrayOf(0, 0, 1, 0, 0, 1, 0, 1, 0, 1),
                    intArrayOf(1, 0, 1, 0, 1, 1, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 1, 1, 0, 0, 0, 1)
            )
    ).print()
}

class Solution1031 {

    private val visited = hashSetOf<Pair<Int, Int>>()
    var ans = 0

    fun numEnclaves(A: Array<IntArray>): Int {

        if (A.isEmpty() || A[0].isEmpty()) {
            return 0
        }

        for (i in 0 until A.size) {
            for (j in 0 until A[0].size) {
                ans += maxOf(dfs(A, i, j), 0)
            }
        }
        return ans
    }

    private fun dfs(matrix: Array<IntArray>, i: Int, j: Int): Int {
        println("$i, $j")
        if (Pair(i, j) in visited) {
            return 0
        }

        if (i < 0 || j < 0 || i > matrix.lastIndex || j > matrix[0].lastIndex) {
            return -50000
        }

        visited.add(Pair(i, j))

        return if (matrix[i][j] == 1) {
            dfs(matrix, i + 1, j) +
                    dfs(matrix, i - 1, j) +
                    dfs(matrix, i, j + 1) +
                    dfs(matrix, i, j - 1) + 1
        } else {
            0
        }

    }
}