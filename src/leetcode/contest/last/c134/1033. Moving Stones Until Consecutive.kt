package leetcode.contest.last.c134

fun main(args: Array<String>) {
    val s = Solution1033()
    s.numMovesStones(1, 2, 5).forEach {
        print("$it")
    }
    s.numMovesStones(4, 3, 2).forEach {
        print("$it")
    }
}

class Solution1033 {
    fun numMovesStones(a: Int, b: Int, c: Int): IntArray {
        val array = intArrayOf(a, b, c)
        array.sort()
        return cal(array[0], array[1], array[2])
    }

    private fun cal(a: Int, b: Int, c: Int): IntArray {
        val max = (c - b - 1) + (b - a - 1)
        var min = if (b - a == 1) {
            0
        } else {
            1
        } + if (c - b == 1) {
            0
        } else {
            1
        }
        if (b - a == 2 || c - b == 2) {
            min = 1
        }
        return intArrayOf(min, max)
    }
}