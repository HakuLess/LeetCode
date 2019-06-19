package leetcode.contest.b02

import leetcode.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution1087()
    s.permute("abcd").forEach {
        println(it)
    }
    s.permute("{a,b}c{d,e}f").forEach {
        println(it)
    }
}

class Solution1087 {
    fun permute(S: String): Array<String> {

        val list = arrayListOf<StringBuilder>()
        list.add(StringBuilder())
        var s = ""
        var isIn = false
        for (i in 0 until S.length) {
            if (S[i] == '{') {
                isIn = true
            } else if (S[i] == '}') {
                val arrayList = arrayListOf<String>()

                s.split(',').forEach { ch ->
                    val temp = ArrayList(list)
                    temp.forEach {
                        arrayList.add(it.toString() + ch)
                    }
                }
                list.clear()
                list.addAll(arrayList.map { StringBuilder(it) })
                isIn = false
                s = ""
            } else {
                if (isIn) {
                    s += S[i]
                } else {
                    list.forEach {
                        it.append(S[i])
                    }
                }
            }
        }

        val res = list.map { it.toString() }.toTypedArray()
        res.sort()
        return res
    }
}