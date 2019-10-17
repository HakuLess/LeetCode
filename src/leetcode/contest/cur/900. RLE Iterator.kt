package leetcode.contest.cur

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = RLEIterator(intArrayOf(811, 903, 310, 730, 899, 684, 472, 100, 434, 611))
    intArrayOf(358, 345, 154, 265, 73, 220, 138, 4, 170, 88).forEach {
        s.next(it).print()
    }
}

class RLEIterator(A: IntArray) {
    private val nums = Stack<Pair<Int, Int>>()

    init {
        for (i in A.indices.reversed()) {
            if (i % 2 == 0 && A[i] > 0) {
                nums.add(Pair(A[i], A[i + 1]))
            }
        }
    }

    fun next(n: Int): Int {
//        nums.forEach {
//            println("${it.first}: ${it.second}")
//        }
        var it = n
        while (it > 0) {
            if (nums.isEmpty()) {
                return -1
            }
            val item = nums.pop()
            if (item.first >= it) {
                if (item.first - it > 0) {
                    nums.add(Pair(item.first - it, item.second))
                }
                return item.second
            }
            it -= item.first
        }
        return -1
    }

}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * var obj = RLEIterator(A)
 * var param_1 = obj.next(n)
 */