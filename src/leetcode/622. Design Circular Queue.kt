package leetcode

class MyCircularQueue(k: Int) {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    private val queue = IntArray(k)
    var first = 0
    var last = 0
    var size = k

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    fun enQueue(value: Int): Boolean {
        return if (isFull()) {
            false
        } else {
            queue[last % size] = value
            last += 1
            true
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    fun deQueue(): Boolean {
        return if (isEmpty()) {
            false
        } else {
            first += 1
            true
        }
    }

    /** Get the front item from the queue. */
    fun Front(): Int {
        if (isEmpty()) {
            return -1
        }
        return queue[first % size]
    }

    /** Get the last item from the queue. */
    fun Rear(): Int {
        if (isEmpty()) {
            return -1
        }
        return queue[(last - 1) % size]
    }

    /** Checks whether the circular queue is empty or not. */
    fun isEmpty(): Boolean {
        return first == last
    }

    /** Checks whether the circular queue is full or not. */
    fun isFull(): Boolean {
        return last - size == first
    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */