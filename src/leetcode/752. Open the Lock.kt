import java.util.*

class Solution {
    fun openLock(deadends: Array<String>, target: String): Int {
        if ("0000" in deadends) {
            return -1
        }

        var ans = -1
        val queue: Queue<String> = LinkedList<String>()
        queue.add("0000")

        val hashSet = hashSetOf<String>()
        hashSet.add("0000")
        while (queue.isNotEmpty()) {
            ans++

            val size = queue.size
            for (num in 0 until size) {
                val str = queue.poll()
                if (str == target) {
                    return ans
                }
                for (i in 0..8) {
                    val d1 = when (i) {
                        0 -> ((Integer.parseInt(str[0].toString()) + 1) % 10).toString()
                        4 -> ((Integer.parseInt(str[0].toString()) + 9) % 10).toString()
                        else -> str[0].toString()
                    }
                    val d2 = when (i) {
                        1 -> ((Integer.parseInt(str[1].toString()) + 1) % 10).toString()
                        5 -> ((Integer.parseInt(str[1].toString()) + 9) % 10).toString()
                        else -> str[1].toString()
                    }
                    val d3 = when (i) {
                        2 -> ((Integer.parseInt(str[2].toString()) + 1) % 10).toString()
                        6 -> ((Integer.parseInt(str[2].toString()) + 9) % 10).toString()
                        else -> str[2].toString()
                    }
                    val d4 = when (i) {
                        3 -> ((Integer.parseInt(str[3].toString()) + 1) % 10).toString()
                        7 -> ((Integer.parseInt(str[3].toString()) + 9) % 10).toString()
                        else -> str[3].toString()
                    }
                    val move = d1 + d2 + d3 + d4
                    if (move !in hashSet && move !in deadends) {
                        hashSet.add(move)
                        queue.add(move)
                    }
                }
            }
        }

        return -1
    }
}