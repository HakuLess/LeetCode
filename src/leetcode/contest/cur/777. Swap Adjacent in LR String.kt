package leetcode.contest.cur

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution777()
    s.canTransform("XXRXXLXXXX", "XXXXRXXLXX").print()
    s.canTransform("XLLR", "LXLX").print()
    s.canTransform("RL", "LR").print()
    s.canTransform("LR", "RL").print()
}

class Solution777 {
    fun canTransform(start: String, end: String): Boolean {
        if (start.filter { it != 'X' } !=
                end.filter { it != 'X' }) {
            return false
        }

        val r: Queue<Int> = LinkedList()
        val l: Queue<Int> = LinkedList()
        for (i in 0 until start.length) {
            if (start[i] == 'R') {
                r.add(i)
            } else if (start[i] == 'L') {
                l.add(i)
            }
        }

        for (i in 0 until end.length) {
            if (end[i] == 'R') {
                if (r.isEmpty() || i < r.poll()) {
                    return false
                }
            } else if (end[i] == 'L') {
                if (l.isEmpty() || i > l.poll()) {
                    return false
                }
            }
        }
        return l.isEmpty() && r.isEmpty()
    }
}