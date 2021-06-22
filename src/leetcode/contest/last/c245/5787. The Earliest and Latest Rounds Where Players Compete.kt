package leetcode.contest.last.c245

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5787()
//    s.earliestAndLatest(11, 2, 4).print()
//    s.earliestAndLatest(5, 1, 5).print()
    s.earliestAndLatest(7, 3, 4).print()
}

class Solution5787 {
    fun earliestAndLatest(n: Int, firstPlayer: Int, secondPlayer: Int): IntArray {
        val arr = ArrayList<Int>()
        for (i in 1..n) arr.add(i)
        fun dfs(left: ArrayList<Int>, right: ArrayList<Int>, step: Int): Pair<Int, Int> {
            if (left.isEmpty()) {
                return dfs(ArrayList(right.sorted()), arrayListOf(), step + 1)
            }
            if (left.size == 1) {
                right.add(left[0])
                return dfs(ArrayList(right.sorted()), arrayListOf(), step + 1)
            }
            val a = left.removeAt(0)
            val b = left.removeAt(left.lastIndex)
            return if (a == firstPlayer && b == secondPlayer) {
                Pair(step, step)
            } else if (a == firstPlayer || a == secondPlayer) {
                right.add(a)
                dfs(ArrayList(left), ArrayList(right), step)
            } else if (b == firstPlayer || b == secondPlayer) {
                right.add(b)
                dfs(ArrayList(left), ArrayList(right), step)
            } else {
                right.add(a)
                val x = dfs(ArrayList(left), ArrayList(right), step)
                right.remove(a)
                right.add(b)
                val y = dfs(ArrayList(left), ArrayList(right), step)
                Pair(minOf(x.first, y.first), maxOf(x.second, y.second))
            }
        }
        return dfs(arr, arrayListOf<Int>(), 1).toList().toIntArray()
    }
}