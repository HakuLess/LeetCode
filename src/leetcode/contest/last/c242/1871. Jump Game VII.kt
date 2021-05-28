package leetcode.contest.last.c242

import leetcode.contest.utils.print
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solution1871()
    s.canReach("011010", 2, 3).print()
    s.canReach("01101110", 2, 3).print()
}

class Solution1871 {
    fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {
        val l = ArrayList<Int>()
        for (i in s.indices) {
            if (s[i] == '0') l.add(i)
        }
        val list = ArrayList<Pair<Int, Int>>()
        list.add(Pair(minJump, maxJump))
        for (i in 1 until l.size) {
            if (list.isEmpty()) return false
            while (l[i] > list[0].second) {
                list.removeAt(0)
                if (list.isEmpty()) return false
            }
            if (l[i] < list[0].first) {
                continue
            } else {
                if (l[i] == s.lastIndex) {
                    return true
                }
                list.add(Pair(l[i] + minJump, l[i] + maxJump))
            }
        }
        return false
    }
}