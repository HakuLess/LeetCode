package leetcode.normal

import leetcode.contest.utils.print
import java.util.Stack

// todo study
fun main(args: Array<String>) {
    val s = Solution85()
    s.maximalRectangle(arrayOf(
            charArrayOf('1', '0', '1', '0', '0'),
            charArrayOf('1', '0', '1', '1', '1'),
            charArrayOf('1', '0', '1', '1', '1'),
            charArrayOf('1', '0', '0', '1', '0')
    )).print()
}

class Solution85 {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty()) {
            return 0
        }
        return maxRectangle(matrix.size, matrix[0].size, matrix.map {
            it.map { it - '0' }.toIntArray()
        }.toTypedArray())
    }

    // Finds the maximum area under the histogram represented
    // by histogram.  See below article for details.
    // https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
    private fun maxHist(R: Int, C: Int, row: IntArray): Int {
        // Create an empty stack. The stack holds indexes of
        // hist[] array/ The bars stored in stack are always
        // in increasing order of their heights.
        val result = Stack<Int>()

        // Top of stack
        var topVal: Int

        // Initialize max area in current row (or histogram)
        var maxArea = 0

        // Initialize area with current top
        var area = 0

        // Run through all bars of given histogram (or row)
        var i = 0
        while (i < C) {
            // If this bar is higher than the bar on top stack,
            // push it to stack
            if (result.empty() || row[result.peek()] <= row[i])
                result.push(i++)
            else {
                // If this bar is lower than top of stack, then
                // calculate area of rectangle with stack top as
                // the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before
                // top in stack is 'left index'
                topVal = row[result.peek()]
                result.pop()
                area = topVal * i

                if (!result.empty())
                    area = topVal * (i - result.peek() - 1)
                maxArea = maxOf(area, maxArea)
            }
        }

        // Now pop the remaining bars from stack and calculate
        // area with every popped bar as the smallest bar
        while (!result.empty()) {
            topVal = row[result.peek()]
            result.pop()
            area = topVal * i
            if (!result.empty())
                area = topVal * (i - result.peek() - 1)

            maxArea = maxOf(area, maxArea)
        }
        return maxArea
    }

    // Returns area of the largest rectangle with all 1s in A[][]
    private fun maxRectangle(R: Int, C: Int, A: Array<IntArray>): Int {
        // Calculate area for first row and initialize it as result
        var result = maxHist(R, C, A[0])

        // iterate over row to find maximum rectangular area
        // considering each row as histogram
        for (i in 1 until R) {
            for (j in 0 until C)
            // if A[i][j] is 1 then add A[i -1][j]
                if (A[i][j] == 1) A[i][j] += A[i - 1][j]
            // Update result if area with current row (as last
            // row of rectangle) is more
            result = maxOf(result, maxHist(R, C, A[i]))
        }
        return result
    }
}