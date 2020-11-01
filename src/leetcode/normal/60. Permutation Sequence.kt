package leetcode.normal

import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    val s = Solution60()
    s.getPermutation(3, 3).print()
    s.getPermutation(4, 9).print()
}

class Solution60 {
    fun getPermutation(n: Int, k: Int): String {
        val sb = StringBuilder()
        val factor = intArrayOf(1, 1, 2, 6, 24, 120, 720, 5040, 40320)
        val list = LinkedList<Int>()
        for (i in 1..9) {
            list.add(i)
        }
        var last = k
        for (i in n downTo 1) {
            var index = last / factor[i - 1]
            last %= factor[i - 1]
            index = if (last > 0) index + 1 else index
            if (last == 0)
                last = factor[i - 1]
            sb.append(list.removeAt(index - 1))
        }
        return sb.toString()
    }
}