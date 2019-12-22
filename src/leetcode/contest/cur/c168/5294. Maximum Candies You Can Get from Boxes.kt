package leetcode.contest.cur.c168

import java.util.*
import kotlin.collections.ArrayList

class Solution5294 {
    fun maxCandies(status: IntArray, candies: IntArray, keys: Array<IntArray>, containedBoxes: Array<IntArray>, initialBoxes: IntArray): Int {
        val queue: Queue<Int> = LinkedList<Int>()
        initialBoxes.forEach {
            queue.add(it)
        }
        var ans = 0
        val getKeys = ArrayList<Int>()

        while (queue.isNotEmpty()) {
            val size = queue.size
            var open = false
            for (i in 0 until size) {
                val item = queue.poll()
                if (status[item] == 1 || getKeys.contains(item)) {
                    open = true
                    ans += candies[item]
                    containedBoxes[item].forEach {
                        queue.offer(it)
                    }
                    keys[item].forEach {
                        getKeys.add(it)
                    }
                } else {
                    queue.offer(item)
                }
            }

            if (!open) {
                return ans
            }
        }
        return ans
    }
}