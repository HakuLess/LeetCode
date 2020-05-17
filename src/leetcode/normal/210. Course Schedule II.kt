package leetcode.normal

import leetcode.contest.utils.Graph
import leetcode.contest.utils.print
import leetcode.contest.utils.topologicalSort
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val s = Solution210()
    s.findOrder(2, arrayOf(intArrayOf(1, 0))).print()
}

class Solution210 {

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val g = Graph(numCourses)
        prerequisites.forEach {
            g.addEdgeOri(it[1], it[0])
        }
        return g.topologicalSort().toIntArray()
    }

//    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
//        val inDegree = IntArray(numCourses)
//        prerequisites.forEach {
//            inDegree[it[0]]++
//        }
//
//        val queue: Queue<Int> = LinkedList<Int>()
//        for (i in inDegree.indices) {
//            if (inDegree[i] == 0)
//                queue.add(i)
//        }
//        val ans = ArrayList<Int>()
//        while (queue.isNotEmpty()) {
//            val size = queue.size
//            for (i in 0 until size) {
//                val item = queue.poll()
//                ans.add(item)
//                println(item)
//                prerequisites.forEach {
//                    if (it[1] == item) {
//                        inDegree[it[0]]--
//                        if (inDegree[it[0]] == 0) {
//                            queue.offer(it[0])
//                        }
//                    }
//                }
//            }
//        }
//        return if (ans.size == numCourses) {
//            ans.toIntArray()
//        } else {
//            intArrayOf()
//        }
//    }
}