package leetcode.contest.last.b10

class Solution5079 {
    fun arraysIntersection(arr1: IntArray, arr2: IntArray, arr3: IntArray): List<Int> {
        return arr1.filter {
            it in arr2 && it in arr3
        }
    }
}