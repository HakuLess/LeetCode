package leetcode.contest.cur.b12

import leetcode.contest.utils.print
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val l = Leaderboard()
    l.addScore(1, 73)
    l.addScore(2, 56)
    l.addScore(3, 39)
    l.addScore(4, 51)
    l.addScore(5, 4)
    l.top(1).print()
    l.reset(1)
    l.reset(2)
    l.addScore(2, 51)
    l.top(3).print()
}

class Leaderboard() {

    val map = HashMap<Int, Int>()

    fun addScore(playerId: Int, score: Int) {
        map[playerId] = map.getOrDefault(playerId, 0) + score

        map.forEach {
            println("${it.key}: ${it.value}")
        }
        println()
    }

    fun top(K: Int): Int {
        val sorted = map.toSortedMap(compareBy<Int> { -map[it]!! }.thenBy { it })
        var ans = 0
        var t = 0
        println("sorted")
        sorted.forEach {
            println("${it.key}: ${it.value}")
        }
        println()
        sorted.forEach {
            ans += it.value
            println("${it.key}: ${it.value}")
            t++
            if (t == K) {
                return ans
            }
        }
        return ans
    }

    fun reset(playerId: Int) {
        map[playerId] = 0

        map.forEach {
            println("${it.key}: ${it.value}")
        }
        println()
    }

}