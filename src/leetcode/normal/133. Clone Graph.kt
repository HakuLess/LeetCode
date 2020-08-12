package leetcode.normal

import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}

class Solution133 {
    private val map = HashMap<Int, Node>()

    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        if (node.`val` in map) return map[node.`val`]
        val ans = Node(node.`val`).also {
            map[node.`val`] = it
        }
        node.neighbors.forEach {
            val clone = if (it!!.`val` in map) {
                map[it.`val`]!!
            } else cloneGraph(it)

            ans.neighbors.add(clone)
        }
        return ans
    }
}