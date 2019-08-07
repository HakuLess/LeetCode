package leetcode.normal

import leetcode.contest.utils.ListNode
import java.util.*

class Solution445 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val stack1 = Stack<Int>()
        val stack2 = Stack<Int>()

        var list1 = l1
        if (list1 != null) {
            while (list1 != null) {
                stack1.push(list1.`val`)
                list1 = list1.next
            }
        }

        var list2 = l2
        if (list2 != null) {
            while (list2 != null) {
                stack2.push(list2.`val`)
                list2 = list2.next
            }
        }

        val ans = Stack<Int>()
        var add = 0
        while (stack1.isNotEmpty() || stack2.isNotEmpty()) {
            val num1 = if (stack1.isEmpty()) 0 else stack1.pop()
            val num2 = if (stack2.isEmpty()) 0 else stack2.pop()
            println("$num1 + $num2 + $add")

            ans.push((num1 + num2 + add) % 10)
            add = (num1 + num2 + add) / 10
        }
        if (add == 1) {
            ans.push(1)
        }
        ans.forEach {
            print("$it, ")
        }

        var head = ListNode(0)
        val answer = head
        while (ans.isNotEmpty()) {
            val node = ListNode(ans.pop())
            head.next = node
            head = head.next!!
        }

        return answer.next
    }
}