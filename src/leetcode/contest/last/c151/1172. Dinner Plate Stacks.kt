package leetcode.contest.last.c151

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val D = DinnerPlates(2)
    D.push(1);
    D.push(2);
    D.push(3);
    D.push(4);
    D.push(5);         // The stacks are now:  2  4
    D.popAtStack(0).print()
    D.push(20);        // The stacks are now: 20  4
    D.push(21);        // The stacks are now: 20  4 21
    D.popAtStack(0).print()   // Returns 20.  The stacks are now:     4 21
    D.popAtStack(2).print()   // Returns 21.  The stacks are now:     4
    D.pop().print()          // Returns 5.  The stacks are now:      4
    D.pop().print()          // Returns 5.  The stacks are now:      4
    D.pop().print()          // Returns 5.  The stacks are now:      4
    D.pop().print()          // Returns 5.  The stacks are now:      4
    D.pop().print()          // Returns 5.  The stacks are now:      4
}

class DinnerPlates(capacity: Int) {

    val s = capacity
    val l = arrayListOf<Stack<Int>>()
    var head = 0

    fun push(`val`: Int) {
        if (l.lastIndex < head) {
            l.add(Stack())
        }
        l[head].push(`val`)
        while (l.lastIndex >= head && l[head].size == s) {
            head++
        }
    }

    fun pop(): Int {
        for (i in l.lastIndex downTo 0) {
            if (l[i].size == 0) {
                l.removeAt(i)
            } else if (l[i].size > 0) {
                return l[i].pop()
            }
        }
        return -1
    }

    fun popAtStack(index: Int): Int {
        if (index >= l.size) {
            return -1
        }
        val s = l[index]
        return if (s.isEmpty()) {
            -1
        } else {
            head = minOf(head, index)
            s.pop()
        }
    }

}