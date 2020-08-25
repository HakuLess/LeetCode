package leetcode.contest.cur.leetcode.c203

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5497()
    s.findLatestStep(intArrayOf(3, 5, 1, 2, 4), 1).print()
    s.findLatestStep(intArrayOf(3, 5, 1, 2, 4), 2).print()
    s.findLatestStep(intArrayOf(1), 1).print()
    s.findLatestStep(intArrayOf(2, 1), 2).print()
    s.findLatestStep(intArrayOf(4, 3, 2, 1), 1).print()
}

class Solution5497 {
    fun findLatestStep(arr: IntArray, m: Int): Int {
        var ans = -1
        val count = IntArray(arr.size) { 0 }
        val seen = HashMap<Int, Int>()

        for (i in arr.indices) {
            val index = arr[i] - 1
            count[index] = 1
            var left = 0
            var right = 0

            if (index - 1 in count.indices) {
                left = count[index - 1]
            }
            if (index + 1 in count.indices) {
                right = count[index + 1]
            }

            count[index] = left + right + 1
            count[index - left] = left + right + 1
            count[index + right] = left + right + 1

            seen[left] = seen.getOrDefault(left, 0) - 1
            seen[right] = seen.getOrDefault(right, 0) - 1
            seen[count[index]] = seen.getOrDefault(count[index], 0) + 1

            if (seen[m] ?: 0 > 0) {
                ans = i + 1
            }
        }
        return ans
    }
}