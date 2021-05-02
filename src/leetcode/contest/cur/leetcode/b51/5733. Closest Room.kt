package leetcode.contest.cur.leetcode.b51

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution5733()
    s.closestRoom("[[2,2],[1,2],[3,2]]".toGrid(), "[[3,1],[3,3],[5,2]]".toGrid()).print()
}

class Solution5733 {
    fun closestRoom(rooms: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val ts = TreeSet<Int>()
        var cur = 0
        val ans = HashMap<String, Int>()
        rooms.sortByDescending { it[1] }
        val st = queries.sortedByDescending { it[1] }
        st.forEach {
            while (cur in rooms.indices && rooms[cur][1] >= it[1]) {
                ts.add(rooms[cur][0])
                cur++
            }
            val key = it.joinToString(",")
            val a = ts.floor(it[0])
            val b = ts.ceiling(it[0])
            ans[key] = if (a == null && b == null) -1
            else if (a == null) b!!
            else if (b == null) a
            else if (abs(a - it[0]) <= abs(b - it[0])) a
            else b
        }
        return queries.map { ans[it.joinToString(",")]!! }.toIntArray()
    }
}