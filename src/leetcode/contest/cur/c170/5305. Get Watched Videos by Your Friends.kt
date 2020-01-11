package leetcode.contest.cur.c170

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution5305()
    s.watchedVideosByFriends(listOf(listOf("A", "B"), listOf("C"), listOf("B", "C"), listOf("D")),
            arrayOf(intArrayOf(1, 2), intArrayOf(0, 3), intArrayOf(0, 3), intArrayOf(1, 2)), 0, 2).forEach {
        it.print()
    }
    s.watchedVideosByFriends(listOf(listOf("xk", "qvgjjsp", "sbphxzm"), listOf("rwyvxl", "ov")),
            arrayOf(intArrayOf(1), intArrayOf(0)), 0, 1).forEach {
        it.print()
    }
}

class Solution5305 {
    fun watchedVideosByFriends(watchedVideos: List<List<String>>, friends: Array<IntArray>, id: Int, level: Int): List<String> {
        val queue: Queue<Int> = LinkedList<Int>()
        queue.add(id)
        val seen = HashSet<Int>()
        seen.add(id)
        var step = -1
        val ans = HashMap<String, Int>()
        while (queue.isNotEmpty()) {
            step++
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                when {
                    step == level -> {
                        watchedVideos[item].forEach {
                            ans[it] = ans.getOrDefault(it, 0) + 1
                        }
                    }
                    step > level -> {
                        val p = HashMap<Int, String>()
                        ans.forEach {
                            p[it.value] = it.key
                        }
                        return p.toSortedMap(compareBy<Int> { it }.thenBy { p[it] }).values.toList()
                    }
                    else -> {
                        friends[item].forEach {
                            if (it !in seen) {
                                queue.offer(it)
                                seen.add(it)
                            }
                        }
                    }
                }
            }
        }
        return ans.toSortedMap(compareBy<String> { ans[it] }.thenBy { it }).keys.toList()
    }
}