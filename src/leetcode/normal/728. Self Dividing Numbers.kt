package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution728()
    s.selfDividingNumbers(1, 22).joinToString().print()
}

class Solution728 {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        return (left..right).filter { i ->
            i.toString().all {
                it != '0' && i % (it - '0') == 0
            }
        }
    }
}