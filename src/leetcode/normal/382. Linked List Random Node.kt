package leetcode.normal

import leetcode.contest.utils.ListNode
import leetcode.contest.utils.count
import java.util.*

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution382(head: ListNode?) {

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    val start = head
    var n = start
    val c = start.count()

    /** Returns a random node's value. */
    fun getRandom(): Int {
        val next = Random().nextInt(c)
        for (i in 0..next) {
            if (n != null && n!!.next != null) {
                n = n!!.next
            } else {
                n = start
            }
        }
        return n!!.`val`
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(head)
 * var param_1 = obj.getRandom()
 */