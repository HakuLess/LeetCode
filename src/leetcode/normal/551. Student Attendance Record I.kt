package leetcode.normal

class Solution551 {
    fun checkRecord(s: String): Boolean {
        var aNum = 0
        var lNum = 0
        s.forEach {
            if (it == 'A') {
                aNum++
                lNum = 0
                if (aNum > 1) {
                    return false
                }
            } else if (it == 'L') {
                lNum++
                if (lNum > 2) {
                    return false
                }
            } else {
                lNum = 0
            }
        }
        return true
    }
}