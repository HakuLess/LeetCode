package leetcode.contest.last.c184

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5381()
    s.processQueries(intArrayOf(3, 1, 2, 1), 5).print()
}

class Solution5381 {
    fun processQueries(queries: IntArray, m: Int): IntArray {
        val cur = LinkedList<Int>()
        for (i in 1..m) {
            cur.add(i)
        }
        val ans = arrayListOf<Int>()
        queries.forEach {
            val index = cur.indexOf(it)
            ans.add(index)

            cur.removeAt(index)
            cur.add(0, it)
        }

        return ans.toIntArray()
    }
}