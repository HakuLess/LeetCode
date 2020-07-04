package leetcode.contest.last.b27

import leetcode.contest.utils.print


fun main(args: Array<String>) {
    val s = Solution5410()
    s.checkIfPrerequisite(2, arrayOf(intArrayOf(1, 0)), arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))).print()
}

class Solution5410 {

    fun checkIfPrerequisite(n: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
        val matrix = Array<BooleanArray>(n) {
            BooleanArray(n) { false }
        }
        prerequisites.forEach {
            matrix[it[0]][it[1]] = true
        }
        for (i in 0 until n) {
            for (j in 0 until n) {
                for (k in 0 until n) {
                    if (matrix[j][i] && matrix[i][k]) {
                        matrix[j][k] = true
                    }
                }
            }
        }
        return queries.map {
            matrix[it[0]][it[1]]
        }.toBooleanArray()
    }

//    class Node {
//        var adj = ArrayList<Node>()
//        var visited = false
//    }
//
//    fun checkIfPrerequisite(n: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
//        val nodes = Array<Node>(n) { Node() }
//        for (e in prerequisites) {
//            nodes[e[0]].adj.add(nodes[e[1]])
//        }
//        val ans = ArrayList<Boolean>(queries.size)
//        for (q in queries) {
//            for (node in nodes) {
//                node.visited = false
//            }
//            dfs(nodes[q[0]])
//            ans.add(nodes[q[1]].visited)
//        }
//        return ans
//    }
//
//    fun dfs(root: Node) {
//        if (root.visited) {
//            return
//        }
//        root.visited = true
//        for (node in root.adj) {
//            dfs(node)
//        }
//    }

//    fun checkIfPrerequisite(n: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
//        return queries.map {
//            helper(it, prerequisites)
//        }.toBooleanArray()
//    }
//
//    private fun helper(cur: IntArray, prerequisites: Array<IntArray>): Boolean {
//        val next = prerequisites.filter {
//            it[0] == cur[0]
//        }.map { it[1] }
//        return next.contains(cur[1]) || next.any {
//            helper(intArrayOf(it, cur[1]), prerequisites)
//        }
//    }

//    val seen = HashSet<Int>()
//
//    fun checkIfPrerequisite(n: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
//        val map = HashMap<Int, ArrayList<Int>>()
//        prerequisites.forEach {
//            map[it[0]] = map.getOrDefault(it[0], arrayListOf())
//            map[it[0]]!!.add(it[1])
//        }
//        return queries.map {
//            isPre(it, map)
//        }.toBooleanArray()
//    }
//
//    private fun isPre(a: IntArray, map: HashMap<Int, ArrayList<Int>>): Boolean {
//        val list = dfs(a[0], map)
//        return list.contains(a[1])
//    }

        //
//    fun checkIfPrerequisite(n: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
//        val map = HashMap<Int, ArrayList<Int>>()
//        val set = hashSetOf<Int>()
//        for (i in 0 until n) {
//            set.add(i)
//        }
//        prerequisites.forEach {
//            map[it[1]] = map.getOrDefault(it[1], arrayListOf())
//            map[it[1]]!!.add(it[0])
//            set.remove(it[0])
//        }
//        set.forEach {
//            dfs(it, map)
//        }
//        return queries.map {
//            isPre(it, map)
//        }.toBooleanArray()
//    }
//
//    private fun dfs(cur: Int, map: HashMap<Int, ArrayList<Int>>): ArrayList<Int> {
//        if (cur in seen) {
//            return map[cur]!!
//        }
//        val list = map.getOrDefault(cur, arrayListOf())
//        val after = arrayListOf<Int>()
//        list.forEach {
//            after.addAll(dfs(it, map))
//        }
//        after.addAll(list)
//        map[cur] = after
//        seen.add(cur)
//        return map[cur]!!
//    }

//
//    private fun isPre(a: IntArray, map: HashMap<Int, ArrayList<Int>>): Boolean {
//        val cur = a[1]
//        val target = a[0]
//        return (map.getOrDefault(cur, arrayListOf()).contains(target))
//    }
    }