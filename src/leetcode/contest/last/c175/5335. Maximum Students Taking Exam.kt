package leetcode.contest.last.c175

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5335()
//    s.maxStudents(
//            arrayOf(charArrayOf('#', '.', '#', '#', '.', '#'),
//                    charArrayOf('.', '#', '#', '#', '#', '.'),
//                    charArrayOf('#', '.', '#', '#', '.', '#')
//            )
//    ).print()

//    s.maxStudents(
//            arrayOf(
//                    charArrayOf('#', '.', '.', '.', '#'),
//                    charArrayOf('.', '#', '.', '#', '.'),
//                    charArrayOf('.', '.', '#', '.', '.'),
//                    charArrayOf('.', '#', '.', '#', '.'),
//                    charArrayOf('#', '.', '.', '.', '#')
//            )
//    ).print()

    s.maxStudents(
            arrayOf(
                    charArrayOf('#', '#', '#', '#', '#', '#'),
                    charArrayOf('#', '.', '#', '#', '.', '#'),
                    charArrayOf('#', '#', '.', '#', '#', '#'),
                    charArrayOf('#', '.', '.', '#', '.', '#'),
                    charArrayOf('.', '.', '.', '.', '#', '.'),
                    charArrayOf('.', '.', '.', '.', '#', '.')
            )
    ).print()
}

class Solution5335 {

    private val seen = HashMap<String, Int>()
    fun maxStudents(seats: Array<CharArray>): Int {
        return helper(seats, seats.lastIndex)
    }

    private fun helper(seats: Array<CharArray>, end: Int): Int {
        val c = clone(seats, end)
        if (hash(c) in seen) {
            return seen[hash(c)]!!
        }
        var ans = 0

        for (i in seats.indices.reversed()) {
            if (i > end) continue
            for (j in seats[0].indices.reversed()) {
                if (seats[i][j] == '.') {
                    val clone = clone(seats, i)
                    set(clone, i, j)
                    ans = maxOf(ans, 1 + helper(clone, i))
                }
            }
//            println(hash(seats))
        }
//        ans.print()
//        seats.print()
        seen[hash(seats)] = ans
        return ans
    }

    private fun set(seats: Array<CharArray>, x: Int, y: Int) {
        seats[x][y] = '#'
        if (y + 1 in seats[0].indices) {
            seats[x][y + 1] = '#'
            if (x - 1 in seats.indices) {
                seats[x - 1][y + 1] = '#'
            }
        }
        if (y - 1 in seats[0].indices) {
            seats[x][y - 1] = '#'
            if (x - 1 in seats.indices) {
                seats[x - 1][y - 1] = '#'
            }
        }
    }

    private fun clone(seats: Array<CharArray>, index: Int): Array<CharArray> {
        val ans = Array<CharArray>(seats.size) { CharArray(seats[0].size) }
        for (i in seats.indices) {
            for (j in seats[0].indices) {
                ans[i][j] = seats[i][j]
            }
        }
        for (i in index + 1..seats.lastIndex) {
            for (j in seats[0].indices) {
                ans[i][j] = '#'
            }
        }
        return ans
    }

    private fun hash(seats: Array<CharArray>): String {
        var ans = ""
        for (i in seats.indices) {
            for (j in seats[0].indices) {
                ans += seats[i][j] + " "
            }
        }
        return ans
    }
}