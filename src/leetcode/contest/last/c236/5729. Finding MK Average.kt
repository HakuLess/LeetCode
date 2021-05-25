package leetcode.contest.last.c236

import leetcode.contest.utils.MultiSet
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = MKAverage(3, 1)
    s.addElement(3)
    s.addElement(1)
    s.calculateMKAverage().print()
    s.addElement(10)
    s.calculateMKAverage().print()
    s.addElement(5)
    s.addElement(5)
    s.addElement(5)
    s.calculateMKAverage().print()
}

class MKAverage(val m: Int, val k: Int) {

    val left = MultiSet<Int> { it }
    val mid = MultiSet<Int> { it }
    val right = MultiSet<Int> { it }
    val all = arrayListOf<Int>()

    fun addElement(num: Int) {
        if (all.size == m) {
            val it = all.removeAt(0)
            when {
                it <= left.max -> {
                    left.remove(it)
                }
                it <= mid.max -> {
                    mid.remove(it)
                }
                else -> {
                    right.remove(it)
                }
            }
            if (left.size < k) {
                left.add(mid.popLeft())
            }
            if (mid.size < m - 2 * k) {
                mid.add(right.popLeft())
            }
        }

        all.add(num)
        left.add(num)
        if (left.size > k) {
            mid.add(left.popRight())
        }
        if (mid.size > m - 2 * k) {
            right.add(mid.popRight())
        }
    }

    fun calculateMKAverage(): Int {
        if (all.size != m) return -1
        return (mid.sum / mid.size).toInt()
    }
}