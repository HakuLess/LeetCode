package leetcode.normal

import java.util.*

class MyStack() {

    /** Initialize your data structure here. */
    val queueA: Queue<Int> = LinkedList()
    val queueB: Queue<Int> = LinkedList()

    /** Push element x onto stack. */
    fun push(x: Int) {
        queueA.offer(x)
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        while (queueA.size > 1) {
            queueB.offer(queueA.poll())
        }
        val ans = queueA.poll()
        while (queueB.isNotEmpty()) {
            queueA.offer(queueB.poll())
        }
        return ans
    }

    /** Get the top element. */
    fun top(): Int {
        while (queueA.size > 1) {
            queueB.offer(queueA.poll())
        }
        val ans = queueA.poll()
        queueB.offer(ans)
        while (queueB.isNotEmpty()) {
            queueA.offer(queueB.poll())
        }
        return ans
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return queueA.isEmpty() && queueB.isEmpty()
    }

}