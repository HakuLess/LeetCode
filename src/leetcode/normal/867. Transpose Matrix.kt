package leetcode.normal

fun transpose(A: Array<IntArray>): Array<IntArray> {
    if (A.isEmpty() || A[0].isEmpty()) {
        return Array(0) { IntArray(0) }
    }

    val x = A.size
    val y = A[0].size
    val ans = Array(A[0].size) { IntArray(A.size) }

    for (i in 0 until x) {
        for (j in 0 until y) {
            ans[j][i] = A[i][j]
        }
    }
    return ans
}