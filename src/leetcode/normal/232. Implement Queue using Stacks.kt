package leetcode.normal

import java.util.*

class MyQueue() {

    /** Initialize your data structure here. */
    private val stackA = Stack<Int>()
    private val stackB = Stack<Int>()

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        while (stackB.isNotEmpty()) {
            val item = stackB.pop()
            stackA.push(item)
        }
        stackA.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        while (stackA.isNotEmpty()) {
            val item = stackA.pop()
            stackB.push(item)
        }
        return stackB.pop()
    }

    /** Get the front element. */
    fun peek(): Int {
        while (stackA.isNotEmpty()) {
            val item = stackA.pop()
            stackB.push(item)
        }
        return stackB.peek()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return stackA.isEmpty() && stackB.isEmpty()
    }

}