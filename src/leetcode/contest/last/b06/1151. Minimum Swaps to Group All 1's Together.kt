package leetcode.contest.last.b06

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solution1151()
    s.minSwaps(intArrayOf(1, 0, 1, 0, 1)).print()
    s.minSwaps(intArrayOf(0, 0, 0, 1, 0)).print()
    s.minSwaps(intArrayOf(1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1)).print()
}

class Solution1151 {
    fun minSwaps(data: IntArray): Int {
        val c = data.count {
            it == 1
        }
        if (c == 0) {
            return 0
        }
        var ans = Int.MAX_VALUE
        val queue: Queue<Int> = LinkedList()
        for (i in 0..data.lastIndex) {
            if (data[i] == 1) {
                queue.offer(i)
            }
            if (queue.isNotEmpty()) {
                val first = queue.peek()
                if (i - first + 1 == c) {
                    println("$i, $first, $c")
                    ans = minOf(c - queue.size, ans)
                    queue.poll()
                }
            }
        }
        return ans
    }
}