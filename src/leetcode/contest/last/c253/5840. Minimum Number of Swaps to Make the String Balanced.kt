package leetcode.contest.last.c253

class Solution5840 {
    fun minSwaps(s: String): Int {
        var a = 0
        var ans = 0
        s.forEach {
            if (it == ']') {
                if (a == 0) {
                    a++
                    ans++
                }
                else if (a != 0) a--
            } else {
                a++
            }
        }
        return ans
    }
}