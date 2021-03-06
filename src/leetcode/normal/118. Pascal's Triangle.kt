package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution118()
    s.generate(5).print()
}

class Solution118 {
    fun generate(numRows: Int): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        for (i in 1..numRows) {
            result.add(getLine(i))
        }
        return result
    }

    private fun getLine(line: Int): List<Int> {
        when (line) {
            1 -> return arrayListOf(1)
            2 -> return arrayListOf(1, 1)
            else -> {
                val lines = getLine(line - 1)
                val result = arrayListOf<Int>()
                lines.forEachIndexed { index, i ->
                    if (index == 0) {
                        result.add(i)
                    } else {
                        result.add(i + lines[index - 1])
                    }

                    if (index == lines.size - 1) {
                        result.add(i)
                    }
                }
                return result
            }
        }
    }
}