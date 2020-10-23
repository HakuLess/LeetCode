package leetcode.normal

import leetcode.contest.utils.ListNode

class Solution234 {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) {
            return true
        }
        val list = arrayListOf<Int>()
        var p = head
        while (p != null) {
            list.add(p.`val`)
            p = p.next
        }
        for (i in 0..list.size / 2) {
            if (list[i] != list[list.size - 1 - i]) {
                return false
            }
        }
        return true
    }
}