package leetcode.contest.cur.leetcode.b49

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5706()
    s.areSentencesSimilar("My name is Haley", "My Haley").print()
}

class Solution5706 {
    fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
        var a = ArrayList(sentence1.split(" "))
        var b = ArrayList(sentence2.split(" "))
        a.joinToString().print()
        b.joinToString().print()
        if (b.size > a.size) {
            val tmp = a
            a = b
            b = tmp
        }
        for (i in a.indices) {
            if (b.isNotEmpty() && b[0] == a[i]) {
                b.removeAt(0)
            } else break
        }
        for (i in a.indices.reversed()) {
            if (b.isNotEmpty() && b.last() == a[i]) {
                b.removeAt(b.lastIndex)
            } else break
        }
        return b.isEmpty()
    }
}