package leetcode.normal

fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {

    val ans = Array(A.size) { IntArray(A[0].size) }
    for (i in 0 until A.size) {
        ans[i] = A[i].map {
            1 - it
        }.reversed().toIntArray()

    }
    return ans
}