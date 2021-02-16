package leetcode.contest.cur.leetcode.b43

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1718()
//    s.constructDistancedSequence(3).print()
    s.constructDistancedSequence(4).print()
    s.constructDistancedSequence(20).print()
}

class Solution1718 {
    fun constructDistancedSequence(n: Int): IntArray {
        val res = IntArray(n * 2 - 1)
        val visited = BooleanArray(n + 1)

        fun dfs(pos: Int): Boolean {
            if (pos >= n * 2 - 1) {
                return true
            } else if (res[pos] > 0) {
                return dfs(pos + 1)
            }
            for (num in n downTo 1) {
                if (!visited[num]) {
                    if (num == 1) {
                        res[pos] = 1
                        visited[1] = true
                        if (dfs(pos + 1)) {
                            return true
                        }
                        visited[1] = false
                        res[pos] = 0
                    } else {
                        if (pos + num in res.indices && res[pos + num] == 0) {
                            res[pos] = num
                            res[pos + num] = num
                            visited[num] = true
                            if (dfs(pos + 1)) {
                                return true
                            }
                            visited[num] = false
                            res[pos] = 0
                            res[pos + num] = 0
                        }
                    }
                }
            }
            return false
        }
        dfs(0)
        return res
    }
}