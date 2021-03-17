package leetcode.normal

class Solution74 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val sorted = ArrayList<Int>()
        matrix.forEach {
            sorted.addAll(it.toList())
        }
        return sorted.binarySearch(target) >= 0
    }
}
