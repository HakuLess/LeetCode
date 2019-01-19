package leetcode

fun main(args: Array<String>) {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)

    node1.next = node4
    println(isPalindrome(node1))
}

fun isPalindrome(head: ListNode?): Boolean {
    if (head == null) {
        return false
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