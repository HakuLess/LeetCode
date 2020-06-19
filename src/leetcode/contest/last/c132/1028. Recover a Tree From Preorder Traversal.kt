package leetcode.contest.last.c132

import leetcode.contest.utils.TreeNode
import leetcode.normal.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution1027()
    s.recoverFromPreorder("1-401--349---90--88")?.print()
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
        for (i in S.indices) {
            if (S[i] == '-') {
                if (str.isNotEmpty()) {
                    list.add(Pair(str.toInt(), level))
                    str = ""
                    level = 0
                }
                level++
            } else {
                str += S[i]
            }
        }
        list.add(Pair(Integer.valueOf(str), level))

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