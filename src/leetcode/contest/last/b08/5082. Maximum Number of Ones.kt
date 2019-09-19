package leetcode.contest.last.b08

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5082()
    s.maximumNumberOfOnes(3, 3, 2, 1).print()
    s.maximumNumberOfOnes(3, 3, 2, 2).print()
}

class Solution5082 {
    fun maximumNumberOfOnes(width: Int, height: Int, sideLength: Int, maxOnes: Int): Int {
        val c = IntArray(sideLength * sideLength)
        for (i in 0 until width) {
            for (j in 0 until height) {
                c[i % sideLength * sideLength + j % sideLength]++
            }
        }
        c.sortDescending()
        var ans = 0
        for (i in 0 until maxOnes) {
            ans += c[i]
        }
        return ans
    }
}