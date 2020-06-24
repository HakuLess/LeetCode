package leetcode.contest.last.c188

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5406()
//    s.minTime(7, arrayOf(
//            intArrayOf(0, 1),
//            intArrayOf(0, 2),
//            intArrayOf(1, 4),
//            intArrayOf(1, 5),
//            intArrayOf(2, 3),
//            intArrayOf(2, 6)
//    ), listOf(false, false, true, false, true, true, false)).print()

    s.minTime(7, arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 4),
            intArrayOf(1, 5),
            intArrayOf(2, 3),
            intArrayOf(2, 6)
    ), listOf(false, false, true, false, false, true, false)).print()
//
//    s.minTime(7, arrayOf(
//            intArrayOf(0, 1),
//            intArrayOf(0, 2),
//            intArrayOf(1, 4),
//            intArrayOf(1, 5),
//            intArrayOf(2, 3),
//            intArrayOf(2, 6)
//    ), listOf(false, false, false, false, false, false, false)).print()
//
//    s.minTime(4, arrayOf(
//            intArrayOf(0, 1),
//            intArrayOf(1, 2),
//            intArrayOf(0, 3)
//    ), listOf(true, true, true, true)).print()
}

class Solution5406 {
    fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
        val child = HashMap<Int, ArrayList<Int>>()
        edges.forEach {
            child[it[0]] = child.getOrDefault(it[0], arrayListOf())
            child[it[0]]!!.add(it[1])
        }
        return dfs(0, child, hasApple)
    }

    private fun dfs(cur: Int, child: HashMap<Int, ArrayList<Int>>, hasApple: List<Boolean>): Int {
        var total = 0
        child[cur]?.forEach {
            val cost = dfs(it, child, hasApple)
            if (cost > 0 || hasApple[it]) {
                total += 2 + cost
            }
        }
        return total
    }

//    fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
//        val parent = HashMap<Int, Int>()
//        edges.forEach {
//            it.sort()
//            parent[it[1]] = it[0]
//        }
//
//        val ans = IntArray(n)
//        hasApple.forEachIndexed { index, b ->
//            if (b) {
//                ans[index] = 1
//            }
//        }
//        val seen = HashSet<Pair<Int, Int>>()
//        while (ans.filterIndexed { index, i -> index != 0 }.any { it != 0 }) {
//            for (i in ans.indices) {
//                if (ans[i] != 0 && i != 0) {
//                    if (Pair(i, parent[i]!!) in seen) {
//                        ans[i] = 0
//                        continue
//                    }
////                    println("$i to ${parent[i]}")
//                    ans[parent[i]!!] += ans[i] + 2
//                    ans[i] = 0
//                    seen.add(Pair(i, parent[i]!!))
//                }
//            }
//        }
//        return seen.count() * 2
//    }
}