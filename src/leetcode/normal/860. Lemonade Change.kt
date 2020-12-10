package leetcode.normal

class Solution860 {
    fun lemonadeChange(bills: IntArray): Boolean {
        val cur = IntArray(3) { 0 }
        bills.forEach {
            when (it) {
                5 -> {
                    cur[0]++
                }
                10 -> {
                    cur[1]++
                    cur[0]--
                }
                else -> {
                    if (cur[1] > 0) {
                        cur[1]--
                        cur[0]--
                    } else {
                        cur[0] -= 3
                    }
                }
            }
            if (cur.any { it < 0 }) return false
        }
        return true
    }
}