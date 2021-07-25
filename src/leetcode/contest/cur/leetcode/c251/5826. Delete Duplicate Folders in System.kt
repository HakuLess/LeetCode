package leetcode.contest.cur.leetcode.c251

import leetcode.contest.utils.TreeNode
import leetcode.contest.utils.print
import kotlin.text.StringBuilder

fun main(args: Array<String>) {
    val s = Solution5826()
//    s.deleteDuplicateFolder(listOf(listOf("a"), listOf("c"), listOf("d"), listOf("a", "b"), listOf("c", "b"), listOf("d", "a"))).forEach {
//        it.joinToString().print()
//    }
    s.deleteDuplicateFolder(listOf(listOf("a"), listOf("c"),
            listOf("a", "b"), listOf("c", "b"), listOf("a", "b", "x"),
            listOf("a", "b", "x", "y"), listOf("w"), listOf("w", "y"))).forEach {
        it.joinToString().print()
    }
}

class Solution5826 {
    fun deleteDuplicateFolder(paths: List<List<String>>): List<List<String>> {
        val sorted = paths.sortedBy { it.size }
        val map = HashMap<String, ArrayList<Int>>()
        for (i in paths.indices) {
            val cur = StringBuilder()
            paths[i].reversed().forEach {
                cur.append("$it,")
                map[cur.toString()] = map.getOrDefault(cur.toString(), arrayListOf())
                map[cur.toString()]!!.add(i)
            }
        }
        map.forEach { s, arrayList ->
            println("$s : ${arrayList.joinToString(";")}")
        }
        return emptyList()
    }
}