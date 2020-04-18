package leetcode.contest.cur.b24

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val s = Solution5374()
    s.getHappyString(1, 3).print()
    s.getHappyString(10, 100).print()
}

class Solution5374 {
    fun getHappyString(n: Int, k: Int): String {
        val queue: Queue<String> = LinkedList<String>()
        queue.add("a")
        queue.add("b")
        queue.add("c")
        var step = 0

        val set = setOf<Char>('a', 'b', 'c')
        while (queue.isNotEmpty()) {
            val size = queue.size
            step++
            if (step == n) {
                if (queue.size < k) {
                    return ""
                }
                val ans = arrayListOf<String>()
                ans.addAll(queue)
                ans.sort()
                return ans[k - 1]
            }

            for (i in 0 until size) {
                val item = queue.poll()

                set.forEach {
                    if (item.last() != it) {
                        queue.offer(item + it)
                    }
                }
            }
        }
        return ""
    }
}