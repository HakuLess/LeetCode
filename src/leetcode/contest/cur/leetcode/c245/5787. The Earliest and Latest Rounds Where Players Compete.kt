package leetcode.contest.cur.leetcode.c245

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5787()
//    s.earliestAndLatest(11, 2, 4).print()
//    s.earliestAndLatest(5, 1, 5).print()
    s.earliestAndLatest(7, 3, 4).print()
}

class Solution5787 {
    fun earliestAndLatest(n: Int, firstPlayer: Int, secondPlayer: Int): IntArray {
        var max = 0
        var min = 100

        val arr = ArrayList<Int>()
        for (i in 1..n) arr.add(i)

        fun dfs(left: ArrayList<Int>, right: ArrayList<Int>, step: Int) {
            if (left.isEmpty()) {
                dfs(ArrayList(right.sorted()), arrayListOf(), step + 1)
                return
            }
            if (left.size == 1) {
                right.add(left[0])
                dfs(ArrayList(right.sorted()), arrayListOf(), step + 1)
                return
            }
            val a = left.removeAt(0)
            val b = left.removeAt(left.lastIndex)
            if (a == firstPlayer && b == secondPlayer) {
                min = minOf(min, step)
                max = maxOf(max, step)
                return
            } else if (a == firstPlayer || a == secondPlayer) {
                right.add(a)
                dfs(ArrayList(left), ArrayList(right), step)
            } else if (b == firstPlayer || b == secondPlayer) {
                right.add(b)
                dfs(ArrayList(left), ArrayList(right), step)
            } else {
                right.add(a)
                dfs(ArrayList(left), ArrayList(right), step)
                right.remove(a)
                right.add(b)
                dfs(ArrayList(left), ArrayList(right), step)
            }
        }

        dfs(arr, arrayListOf<Int>(), 1)
        return intArrayOf(min, max)
    }
}