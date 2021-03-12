package leetcode.normal

import leetcode.contest.utils.Graph
import leetcode.contest.utils.dijkstra

class Solution331 {
    fun isValidSerialization(preorder: String): Boolean {
        val n = preorder.length
        var i = 0
        var slots = 1
        while (i < n) {
            if (slots == 0) {
                return false
            }
            when (preorder[i]) {
                ',' -> {
                    i++
                }
                '#' -> {
                    slots--
                    i++
                }
                else -> {
                    while (i < n && preorder[i] != ',') {
                        i++
                    }
                    slots++
                }
            }
        }
        return slots == 0
    }
}