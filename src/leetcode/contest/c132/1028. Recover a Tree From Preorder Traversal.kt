package leetcode.contest.c132

import leetcode.TreeNode
import java.util.*

fun main(args: Array<String>) {
    val s = Solution1027()
    s.recoverFromPreorder("1-401--349---90--88")
}

class Solution1027 {
    fun recoverFromPreorder(S: String): TreeNode? {
        if (S.isEmpty()) {
            return null
        }

        // value & level
        val list = arrayListOf<Pair<Int, Int>>()

        var level = 0
        var str = ""
        for (i in 0 until S.length) {
            if (S[i] == '-') {
                if (str.isNotEmpty()) {
                    list.add(Pair(Integer.valueOf(str), level))
                    str = ""
                    level = 0
                }
                level++
            } else {
                str += S[i]
            }
        }
        list.add(Pair(Integer.valueOf(str), level))

//        list.forEach {
//            println("${it.first}  ${it.second}")
//        }

        val stack = Stack<TreeNode>()
        var lastLevel = -1

        val root = TreeNode(list[0].first)
        stack.push(root)

        list.forEachIndexed { index, it ->
            if (index != 0) {
                val node = TreeNode(it.first)
                if (it.second > lastLevel) {
                    stack.peek().left = node
                    stack.push(node)
                    lastLevel = it.second
                } else {
                    while (it.second <= lastLevel) {
                        stack.pop()
                        lastLevel--
                    }
                    stack.peek().right = node
                    stack.push(node)
                    lastLevel = it.second
                }
            }
        }

        return root
    }
}