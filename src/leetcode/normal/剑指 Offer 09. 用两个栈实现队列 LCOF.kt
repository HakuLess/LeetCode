package leetcode.normal

import java.util.*

class CQueue() {

    val st0 = Stack<Int>()
    val st1 = Stack<Int>()

    fun appendTail(value: Int) {
        st0.add(value)
    }

    fun deleteHead(): Int {
        if (st1.isNotEmpty()) {
            return st1.pop()
        }
        while (st0.isNotEmpty()) {
            st1.add(st0.pop())
        }
        if (st1.isEmpty()) {
            return -1
        }
        return st1.pop()
    }

}

/**
 * Your CQueue object will be instantiated and called as such:
 * var obj = CQueue()
 * obj.appendTail(value)
 * var param_2 = obj.deleteHead()
 */