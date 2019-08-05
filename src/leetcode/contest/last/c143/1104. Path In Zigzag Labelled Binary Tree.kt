package leetcode.contest.last.c143

fun main(args: Array<String>) {
    val s = Solution1104()
//    s.pathInZigZagTree(14).forEach {
//        println(it)
//    }
    s.pathInZigZagTree(26).forEach {
        println(it)
    }
}

class Solution1104 {
    fun pathInZigZagTree(label: Int): List<Int> {
        var cur = label
        val ans = arrayListOf<Int>()
        while (cur != 0) {
            ans.add(cur)
            val level = find(cur)
            println("$cur ${level.first} ${level.second}")
            if (level.second % 2 == 0) {
                cur = level.first / 4 + (level.first - cur - 1) / 2
            } else {
                cur = level.first / 2 - (cur - level.first / 2) / 2  - 1
            }
        }
        return ans.reversed()
    }

    private fun find(cur: Int): Pair<Int, Int> {
        var level = 1
        var ans = 0
        while (level <= cur) {
            level *= 2
            ans++
        }
        return Pair(level, ans)
    }
}