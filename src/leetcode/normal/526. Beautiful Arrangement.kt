package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution526()
    s.countArrangement(3).print()
}

class Solution526 {
    var ans = 0
    fun countArrangement(N: Int): Int {
        val set = hashSetOf<Int>()
        for (i in 1..N) {
            set.add(i)
        }
        helper(arrayListOf(), N, set)
        return ans
    }

    private fun helper(list: ArrayList<Int>, N: Int, not: HashSet<Int>) {
        if (!checkCur(list)) {
            return
        }
        if (list.size == N) {
            ans++
            return
        }

        not.forEach {
            list.add(it)
            val temp = HashSet(not)
            temp.remove(it)
            helper(list, N, temp)
            list.remove(it)
        }
    }

    private fun checkCur(list: List<Int>): Boolean {
        list.forEachIndexed { index, i ->
            val max = maxOf(index + 1, i)
            val min = minOf(index + 1, i)
            if (max % min != 0) {
                return false
            }
        }
        return true
    }
}