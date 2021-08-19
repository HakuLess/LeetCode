package leetcode.normal

class Solution551 {
    fun checkRecord(s: String): Boolean {
        var a = 0
        var l = 0
        s.forEach {
            when (it) {
                'A' -> {
                    a++
                    l = 0
                }
                'L' -> l++
                else -> l = 0
            }
            if (a == 2 || l == 3) return false
        }
        return true
    }
}