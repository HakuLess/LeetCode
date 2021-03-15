package leetcode.normal

class Solution326 {
    fun isPowerOfThree(n: Int): Boolean {
        return n > 0
                && n.toString(3).count { it == '1' } == 1
                && n.toString(3).count { it == '2' } == 0
    }
}