package leetcode.contest.last.c194

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5441()
//    s.getFolderNames(arrayOf("wano", "wano", "wano", "wano")).joinToString(", ").print()
    s.getFolderNames(arrayOf("kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)")).joinToString(", ").print()
}

class Solution5441 {
    fun getFolderNames(names: Array<String>): Array<String> {
        val count = hashMapOf<String, Int>()
        val ans = arrayListOf<String>()
        names.forEach {
            if (it !in count) {
                count[it] = 1
                ans.add(it)
            } else {
                var cur = "${it}(${count[it]})"
                while (cur in count) {
                    count[it] = count.getOrDefault(it, 0) + 1
                    cur = "${it}(${count[it]})"
                }
                ans.add(cur)
                count[cur] = count.getOrDefault(cur, 0) + 1
            }
        }
        return ans.toTypedArray()
    }
}