package leetcode.normal

class Solution191 {
    // you need treat n as an unsigned value
    fun hammingWeight(n:Int):Int {
        var ans = 0
        var cur = n
        while (cur != 0) {
            cur = cur and (cur - 1)
            ans++
        }
        return ans
    }
}