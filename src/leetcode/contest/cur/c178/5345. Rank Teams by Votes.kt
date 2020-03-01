package leetcode.contest.cur.c178

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5345()
    s.rankTeams(arrayOf("BCA", "CAB", "CBA", "ABC", "ACB", "BAC")).print()
}

class Solution5345 {
    fun rankTeams(votes: Array<String>): String {
        if (votes.size == 1) {
            return votes[0]
        }

        val m = HashMap<Char, IntArray>()
        votes.forEach {
            it.forEachIndexed { index, c ->
                val cur = m.getOrDefault(c, IntArray(26) { 0 })
                cur[index] = cur[index] + 1
                m[c] = cur
            }
        }

        m.forEach { c, ints ->
            println(c)
            ints.print()
        }

        return votes[0].toCharArray().sortedWith(compareBy({ -m[it]!![0] }, { -m[it]!![1] }, { -m[it]!![2] }, { -m[it]!![3] },
                { -m[it]!![4] }, { -m[it]!![5] }, { -m[it]!![6] }, { -m[it]!![7] }, { -m[it]!![8] }, { -m[it]!![9] },
                { -m[it]!![10] }, { -m[it]!![11] }, { -m[it]!![12] }, { -m[it]!![13] }, { -m[it]!![14] }, { -m[it]!![15] },
                { -m[it]!![16] }, { -m[it]!![17] }, { -m[it]!![18] }, { -m[it]!![19] }, { -m[it]!![20] }, { -m[it]!![21] },
                { -m[it]!![22] }, { -m[it]!![23] }, { -m[it]!![24] }, { -m[it]!![25] }, { it })).joinToString("")
    }
}