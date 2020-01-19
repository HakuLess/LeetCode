package leetcode.contest.cur.c172

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5316()
    s.printVertically("TO BE OR NOT TO BE").forEach {
        it.print()
    }
}

class Solution5316 {
    fun printVertically(s: String): List<String> {
        val ans = ArrayList<CharArray>()
        val max = s.split(' ').maxBy { it.length }!!.length

        for (i in 0 until max) {
            ans.add(CharArray(s.split(' ').size) { ' ' })
        }

        s.split(' ').forEach {
            it.print()
        }

        s.split(' ').forEachIndexed { index, s ->
            println("$index, $s")
            s.forEachIndexed { i, c ->
                ans[i][index] = c
            }
        }

        return ans.map {
            it.joinToString("").trimEnd()
        }
    }
}