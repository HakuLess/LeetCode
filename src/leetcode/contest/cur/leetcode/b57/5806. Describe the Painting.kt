package leetcode.contest.cur.leetcode.b57

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solution5806()
    s.splitPainting("[[1,4,5],[4,7,7],[1,7,9]]".toGrid()).forEach {
        it.joinToString().print()
    }
}

class Solution5806 {
    fun splitPainting(segments: Array<IntArray>): List<List<Long>> {
        val map = TreeMap<Int, Long>()
        segments.forEach {
            map[it[0]] = map.getOrDefault(it[0], 0L) + it[2].toLong()
            map[it[1]] = map.getOrDefault(it[1], 0L) - it[2].toLong()
        }
        val ans = ArrayList<List<Long>>()
        var cur = 0L
        var lst = 1L
        map.forEach { i, i2 ->
            if (cur != 0L) {
                ans.add(listOf(lst, i.toLong(), cur))
            }
            cur += i2
            lst = i.toLong()
        }
        return ans
    }
}