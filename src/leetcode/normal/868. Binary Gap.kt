package leetcode.normal

class Solution868 {
    fun binaryGap(n: Int): Int {
        var pre = -1
        var ans = 0
        n.toString(2).mapIndexed { index, c ->
            if (c == '1') {
                if (pre != -1)
                    ans = maxOf(ans, index - pre - 1)
                pre = index
            }
        }
        return ans
    }
}