package leetcode.normal

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solution126()
    s.findLadders("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog")).forEach {
        it.joinToString(",").print()
    }
}

class Solution126 {
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {

        fun check(cur: String, it: String): Boolean {
            var ans = 0
            for (i in cur.indices) {
                if (cur[i] != it[i]) {
                    ans++
                    if (ans == 2)
                        return false
                }
            }
            return ans == 1
        }

        val words = ArrayList<String>(wordList)
        words.add(beginWord)
        if (endWord !in words) {
            return emptyList()
        }

        val cost = HashMap<String, Int>()
        words.forEach {
            cost[it] = Int.MAX_VALUE / 2
        }
        cost[beginWord] = 0
        val map = HashMap<String, HashSet<String>>()
        for (i in words.indices) {
            for (j in words.indices) {
                if (check(words[i], words[j])) {
                    map[words[i]] = map.getOrDefault(words[i], hashSetOf())
                    map[words[i]]!!.add(words[j])
                    map[words[j]] = map.getOrDefault(words[j], hashSetOf())
                    map[words[j]]!!.add(words[i])
                }
            }
        }
//        map.forEach { s, hashSet ->
//            println(s)
//            println(hashSet.joinToString(", "))
//        }
        val queue: Queue<ArrayList<String>> = LinkedList<ArrayList<String>>()
        queue.add(arrayListOf(beginWord))
        val ans = ArrayList<ArrayList<String>>()
        while (queue.isNotEmpty() && ans.isEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.last() == endWord) {
                    ans.add(item)
                }
                val cur = item.last()
                map[cur]?.forEach {
                    if (cost[cur]!! + 1 <= cost[it]!!) {
                        cost[it] = cost[cur]!! + 1
                        val list = ArrayList(item)
                        list.add(it)
                        queue.add(list)
                    }
                }
            }
        }
        return ans
    }
}