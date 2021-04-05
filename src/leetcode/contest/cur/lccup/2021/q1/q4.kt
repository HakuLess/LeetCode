package leetcode.contest.cur.lccup.`2021`.q1

class Solutionq4 {
    fun escapeMaze(maze: Array<Array<String>>): Boolean {
        val dirs = arrayListOf(Pair(0, 1), Pair(-1, 0), Pair(0, -1), Pair(1, 0))
        val max = maze.size
        val n = maze[0].size
        val m = maze[0][0].length
        fun dfs(x: Int, y: Int, step: Int, a: Int, b: Int): Boolean {
            if (x !in 0..n || y !in 0..m) return false
            if (x == n && y == m) return true
            if (step == max) return false
            var cur = false
            if (maze[step][x][y] == '#' && 100 * x + y + 100 != b) {
                if (a == 1) {
                    dirs.forEach {
                        cur = cur or dfs(x + it.first, y + it.second, step + 1, 0, b)
                    }
                }
                if (b == 1) {
                    dirs.forEach {
                        cur = cur or dfs(x + it.first, y + it.second, step + 1, a, 100 * x + y + 100)
                    }
                }
            } else {
                dirs.forEach {
                    cur = cur or dfs(x + it.first, y + it.second, step + 1, a, b)
                }
            }
            return cur
        }

        return dfs(0, 0, 0, 1, 1)
    }
}