package leetcode.contest.cur.leetcode.c208

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5526()
//    s.maximumRequests(5, arrayOf(
//            intArrayOf(0, 1),
//            intArrayOf(1, 0),
//            intArrayOf(0, 1),
//            intArrayOf(1, 2),
//            intArrayOf(2, 0),
//            intArrayOf(3, 4)
//    )).print()

    s.maximumRequests(3, arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 2),
            intArrayOf(2, 1)
    )).print()

//    s.maximumRequests(5, arrayOf(
//            intArrayOf(0, 3),
//            intArrayOf(3, 1),
//            intArrayOf(1, 2),
//            intArrayOf(2, 0)
//    )).print()
}

class Solution5526 {
    fun maximumRequests(n: Int, requests: Array<IntArray>): Int {
        val m = requests.size
        var ans = 0
        for (i in 0 until (1 shl m)) {
            val state = IntArray(n)
            for (j in 0 until m) {
                if (i and (1 shl j) != 0) {
                    state[requests[j][0]]--
                    state[requests[j][1]]++
                }
            }
            if (state.all { it == 0 })
                ans = maxOf(ans, Integer.bitCount(i))
        }
        return ans
    }

//    fun maximumRequests(n: Int, requests: Array<IntArray>): Int {
//        val cur = IntArray(n)
//        val size = requests.size
//        var ans = 0
//        fun dfs(i: Int, cur: IntArray, set: HashSet<Int>) {
//            println("$i: ${cur.joinToString(", ")}, $set")
//            if (cur.all { it == 0 }) ans = maxOf(ans, set.size)
//            if (i == size) return
//            // not select
//            dfs(i + 1, cur, set)
//
//            // select
//            val clone = cur.clone()
//            clone[requests[i][0]]--
//            clone[requests[i][1]]++
//            val next = HashSet(set)
//            next.add(i)
//            dfs(i + 1, clone, next)
//        }
//
//        dfs(0, cur, hashSetOf<Int>())
//        return ans
//    }
}