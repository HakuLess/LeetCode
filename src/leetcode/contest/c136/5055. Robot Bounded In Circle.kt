package leetcode.contest.c136

class Solution5055 {
    fun isRobotBounded(instructions: String): Boolean {
        var pos = Pair(0, 0)
        val directions = arrayListOf(Pair(0, 1), Pair(-1, 0), Pair(0, -1), Pair(1, 0))
        var index = 0
        var direction = directions[index]

        for (i in 0 until 4) {
            instructions.forEach {
                when (it) {
                    'G' -> pos = Pair(pos.first + direction.first, pos.second + direction.second)
                    'L' -> {
                        index = (index + 1) % 4
                        direction = directions[index]
                    }
                    'R' -> {
                        index = (index + 3) % 4
                        direction = directions[index]
                    }
                }
            }
        }

        return pos.first == 0 && pos.second == 0
    }
}