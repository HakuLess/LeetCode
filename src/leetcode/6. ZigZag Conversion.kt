package leetcode

import java.lang.StringBuilder
import java.util.*

fun main(args: Array<String>) {
    val s = Solution6()
//    s.convert("A", 1).print()
//    s.convert("PAYPALISHIRING", 4).print()
    s.convert("ABCD", 3).print()
}

class Solution6 {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }
        val offset = (numRows - 1) * 2
        val set = hashSetOf<Int>()

        val queue: Queue<Int> = LinkedList<Int>()
        var cur = 0
        while (cur <= s.lastIndex + offset) {
            queue.add(cur)
            cur += offset
            set.add(cur)
        }

        val ans = StringBuilder()
        while (queue.isNotEmpty()) {
            val size = queue.size
            println()
            for (i in 0 until size) {
                val index = queue.poll()
                print("$index, ")
                if (index in 0..s.lastIndex) {
                    ans.append(s[index])
                }

                if (index - 1 > 0 && index - 1 !in set) {
                    queue.add(index - 1)
                    set.add(index - 1)
                }

                if (index + 1 < s.length && index + 1 !in set) {
                    queue.add(index + 1)
                    set.add(index + 1)
                }
            }
        }

        return ans.toString()
    }
}