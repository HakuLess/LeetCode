package leetcode.contest.last.b18

fun main(args: Array<String>) {
    val s = Solution5152()

}

class Solution5152 {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {

        val a = mat.lastIndex
        val b = mat[0].lastIndex

        val ans = Array<IntArray>(mat.size) { IntArray(mat[0].size) }
        for (k in -b..a) {
            val cur = ArrayList<Int>()
            for (i in 0..a) {
                for (j in 0..b) {
                    if (i - j == k) {
                        cur.add(mat[i][j])
                    }
                }
            }
            cur.sort()
            var index = 0
            for (i in 0..a) {
                if (i - k in mat[i].indices) {
                    ans[i][i - k] = cur[index]
                    index++
                }
            }
        }

        return ans
    }
}