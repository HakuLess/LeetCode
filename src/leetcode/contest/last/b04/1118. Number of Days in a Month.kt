package leetcode.contest.last.b04

class Solution1118 {
    fun numberOfDays(Y: Int, M: Int): Int {
        when (M) {
            1, 3, 5, 7, 8, 10, 12 -> {
                return 31
            }
            4, 6, 9, 11 -> {
                return 30
            }
            else -> {
                if (Y % 4 == 0 && Y % 100 != 0) {
                    return 29
                } else {
                    if (Y % 400 == 0) {
                        return 29
                    }
                    return 28
                }
            }
        }

    }
}