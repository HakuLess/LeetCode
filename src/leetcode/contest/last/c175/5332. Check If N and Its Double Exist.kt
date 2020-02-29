package leetcode.contest.last.c175

class Solution5332 {
    fun checkIfExist(arr: IntArray): Boolean {
        arr.forEach { it ->
            if (it == 0) {
                if (arr.count { it == 0 } > 1) {
                    return true
                }
            } else if (arr.contains(it * 2)) {
                return true
            }
        }
        return false
    }
}