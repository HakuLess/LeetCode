package leetcode.contest.last.c142

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solution1096()
    s.braceExpansionII("{a,b}{c{d,e}}").forEach {
        println(it)
    }
//    s.braceExpansionII("{{a,z},a{b,c},{ab,z}}").forEach {
//        println(it)
//    }
}

class Solution1096 {
    fun braceExpansionII(expression: String): List<String> {
        val stack = Stack<Char>()
        var state = 0
        for (i in 0 until expression.length) {
            stack.push(expression[i])
            if (expression[i] == '}') {
                val sb = StringBuilder()
                while (stack.peek() != '{') {
                    sb.append(stack.pop())
                }
                val ans = permute(sb.toString().reversed())
                ans.forEach {
                    it.forEach { ch ->
                        stack.push(ch)
                    }
                    stack.push(',')
                }
            }
        }
        return emptyList()
    }

    private fun permute(S: String): Array<String> {

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