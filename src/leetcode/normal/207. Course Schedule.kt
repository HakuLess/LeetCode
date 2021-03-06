package leetcode.normal

import leetcode.contest.utils.Graph
import leetcode.contest.utils.topologicalSort

class Solution207 {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val g = Graph(numCourses)
        prerequisites.forEach {
            g.addEdgeOri(it[1], it[0])
        }
        return g.topologicalSort().isNotEmpty()
    }
}

//fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
//    val map = hashMapOf<Int, ArrayList<Int>>()
//    prerequisites.forEach {
//        val array = map.getOrDefault(it[0], arrayListOf())
//        array.add(it[1])
//        map[it[0]] = array
//    }
//
//    val visited = IntArray(numCourses) { 0 }
//
//    for (i in 0 until numCourses) {
//        if (!findCircle(i, map, visited)) {
//            return false
//        }
//    }
//    return true
//}
//
//fun findCircle(key: Int, map: HashMap<Int, ArrayList<Int>>,
//               visited: IntArray): Boolean {
//    if (!map.containsKey(key) || visited[key] == 1) {
//        return true
//    }
//    if (visited[key] == -1) {
//        return false
//    }
//
//    visited[key] = -1
//    for (preKey in map[key]!!) {
//        if (!findCircle(preKey, map, visited)) {
//            return false
//        }
//    }
//    visited[key] = 1
//    return true
//}