package leetcode.contest.cur

import leetcode.contest.utils.print
import java.util.HashMap


fun main(args: Array<String>) {
    val s = Solution1074()
    s.numSubmatrixSumTarget(
            arrayOf(
                    intArrayOf(0, 1, 0),
                    intArrayOf(1, 1, 1),
                    intArrayOf(0, 1, 0)
            ), 0
    ).print()

//    s.numSubmatrixSumTarget(
//            arrayOf(
//                    intArrayOf(1, -1),
//                    intArrayOf(-1, 1)
//            ), 0
//    ).print()
}

class Solution1074 {
    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        // Number of columns
        val n = matrix[0].size
        // Number of rows
        val m = matrix.size
        // store the total count of such sub matrices in result variable
        var result = 0

        // Fix the left boundary
        for (left in 0 until n) {
            // Fix the right boundary
            val temp = IntArray(m)
            for (right in left until n) {
                // Compute sum of row elements between the left and right boundary
                for (k in 0 until m) {
                    temp[k] += matrix[k][right]
                }
                // Check for target sum
                result += subArraySumToTarget(temp, target)
            }
        }
        return result
    }

    // Works in O(n)
    private fun subArraySumToTarget(temp: IntArray, target: Int): Int {
        // Use a hashmap of running sum and frequency of that sum
        val map = HashMap<Int, Int>()
        var sum = 0
        var count = 0
        map[0] = 1
        for (i in temp.indices) {
            sum += temp[i]
            if (map.containsKey(sum - target)) {
                count += map[sum - target]!!
            }
            map[sum] = map.getOrDefault(sum, 0) + 1
        }
        return count
    }
}