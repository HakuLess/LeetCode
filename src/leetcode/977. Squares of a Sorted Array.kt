package leetcode

fun sortedSquares(A: IntArray): IntArray {
    return A.map {
        it * it
    }.sorted().toIntArray()
}