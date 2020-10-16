package leetcode.normal

class Solution977 {
    fun sortedSquares(A: IntArray): IntArray {
        return A.map {
            it * it
        }.sorted().toIntArray()
    }
}