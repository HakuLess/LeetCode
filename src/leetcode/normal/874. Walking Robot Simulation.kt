package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution874()
    s.robotSim(intArrayOf(4, -1, 4, -2, 4), arrayOf(
            intArrayOf(2, 4)
    )).print()

    s.robotSim(intArrayOf(4, -1, 3), arrayOf()).print()
}

class Solution874 {
    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        val obSet = obstacles.map { "${it[0]}, ${it[1]}" }.toSet()
        val dirs = arrayListOf(Pair(0, 1), Pair(-1, 0), Pair(0, -1), Pair(1, 0))
        var cur = 0
        var pos = intArrayOf(0, 0)
        var ans = 0
        commands.forEach {
            if (it == -2) {
                cur++
            } else if (it == -1) {
                cur--
                if (cur < 0) cur += 4
            } else {
                var x = 0
                while (x < it) {
                    x++
                    val target = intArrayOf(pos[0], pos[1])
                    target[0] += dirs[cur % 4].first
                    target[1] += dirs[cur % 4].second
                    if (obSet.contains("${target[0]}, ${target[1]}")) {
                        break
                    } else {
                        pos = target
//                        println("reach ${pos.joinToString(", ")}")
                        ans = maxOf(ans, pos[0] * pos[0] + pos[1] * pos[1])
                    }
                }
            }
        }
        return ans
    }
}