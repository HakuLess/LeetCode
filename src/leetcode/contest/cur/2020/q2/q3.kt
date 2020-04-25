package leetcode.contest.cur.`2020`.q2

import leetcode.contest.utils.print
import java.util.*
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solutionq3()
    s.minimalSteps(arrayOf(
            "S#O", "M..", "M.T"
    )).print()

    s.minimalSteps(arrayOf(
            "S#O", "M.#", "M.T"
    )).print()

    s.minimalSteps(arrayOf(
            "S#O", "M.T", "M.."
    )).print()
}

class Solutionq3 {
    class State(var x: Int, var y: Int, var stone: Boolean, var solve: HashSet<Pair<Int, Int>>)

    private fun State.toS():String {
        var ans = "$x,$y,$stone"
        solve.forEach {
            ans += "${it.first},${it.second}&&"
        }
        return ans
    }

    fun minimalSteps(maze: Array<String>): Int {
        val start = State(0, 0, false, hashSetOf())
        var end = Pair(0, 0)
        val wall = hashSetOf<Pair<Int, Int>>()
        val stone = hashSetOf<Pair<Int, Int>>()
        val m = hashSetOf<Pair<Int, Int>>()
        for (i in maze.indices) {
            for (j in maze[0].indices) {
                when (maze[i][j]) {
                    'S' -> {
                        start.x = i
                        start.y = j
                    }
                    'T' -> end = Pair(i, j)
                    'M' -> m.add(Pair(i, j))
                    '#' -> wall.add(Pair(i, j))
                    'O' -> stone.add(Pair(i, j))
                }
            }
        }

        val seen = HashSet<String>()

        val queue: Queue<State> = LinkedList<State>()
        queue.add(start)
        var step = -1
        while (queue.isNotEmpty()) {
            val size = queue.size
            step++
            for (i in 0 until size) {
                val item = queue.poll()
                if (item.toS() !in seen) {
                    seen.add(item.toS())
                } else {
                    continue
                }
                val cur = Pair(item.x, item.y)
                if (cur == end && item.solve.size == m.size) {
                    return step
                }
                if (cur in wall || item.x !in maze.indices || item.y !in maze[0].indices) {
                    continue
                }
                val st = cur in stone
                val solve = HashSet(item.solve)

                if (item.stone && cur in m && cur !in solve) {
                    solve.add(cur)
                    queue.offer(State(item.x + 1, item.y, false, solve))
                    queue.offer(State(item.x - 1, item.y, false, solve))
                    queue.offer(State(item.x, item.y + 1, false, solve))
                    queue.offer(State(item.x, item.y - 1, false, solve))
                } else {
                    queue.offer(State(item.x + 1, item.y, if (st) true else item.stone, item.solve))
                    queue.offer(State(item.x - 1, item.y, if (st) true else item.stone, item.solve))
                    queue.offer(State(item.x, item.y + 1, if (st) true else item.stone, item.solve))
                    queue.offer(State(item.x, item.y - 1, if (st) true else item.stone, item.solve))
                }
            }
        }
        return -1
    }
}