package leetcode

import java.util.HashMap


class Solution957 {

    fun prisonAfterNDays(cells: IntArray, N: Int): IntArray {
        var n = N
        val seen = HashMap<Int, Int>()

        // state  = integer representing state of prison
        var state = 0
        for (i in 0..7) {
            if (cells[i] > 0)
                state = state xor (1 shl i)
        }

        // While days remaining, simulate a day
        while (n > 0) {
            // If this is a cycle, fast forward by
            // seen.get(state) - N, the period of the cycle.
            if (seen.containsKey(state)) {
                n %= seen[state]!! - n
            }
            seen[state] = n

            if (n >= 1) {
                n--
                state = nextDay(state)
            }
        }

        // Convert the state back to the required answer.
        val ans = IntArray(8)
        for (i in 0..7) {
            if (state shr i and 1 > 0) {
                ans[i] = 1
            }
        }

        return ans
    }

    private fun nextDay(state: Int): Int {
        var ans = 0

        // We only loop from 1 to 6 because 0 and 7 are impossible,
        // as those cells only have one neighbor.
        for (i in 1..6) {
            if (state shr i - 1 and 1 == state shr i + 1 and 1) {
                ans = ans xor (1 shl i)
            }
        }

        return ans
    }
//
//    val map = HashMap<IntArray, Int>()
//    fun prisonAfterNDays(cells: IntArray, N: Int): IntArray {
//        if (N == 0) {
//            return cells
//        }
//
//        val next = IntArray(cells.size)
//        for (i in 0 until cells.size) {
//            when (i) {
//                0 -> next[i] = 0
//                cells.size - 1 -> next[i] = 0
//                else -> next[i] = cells[i - 1] xor cells[i + 1]
//            }
//        }
//
//        var num = N - 1
//
//        if (cells in map) {
//            num = N % (map[cells]!! - N)
//            return prisonAfterNDays(next, num)
//        } else {
//            map[cells] = N
//        }
//
//        return prisonAfterNDays(next, num)
//    }
}