package leetcode.normal

import leetcode.contest.utils.print
import leetcode.contest.utils.printInt
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution554()
    s.leastBricks("[[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]".toGrid().toList().map { it.toList() }).print()
}

class Solution554 {
    fun leastBricks(wall: List<List<Int>>): Int {
        val map = HashMap<Int, Int>()
        wall.forEach {
            var cur = 0
            it.forEach {
                cur += it
                map[cur] = map.getOrDefault(cur, 0) + 1
            }
            map.remove(cur)
        }
        return wall.size - (map.values.maxOrNull() ?: 0)
    }
}