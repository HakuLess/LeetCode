package leetcode

class Solution89 {
    fun grayCode(n: Int): List<Int> {
        val ans = arrayListOf(0)
        if (n == 0) {
            return ans
        }
        var k = 1
        while (k <= n) {
            ans.addAll(ArrayList(ans).reversed().map {
                (it + Math.pow(2.toDouble(), (k - 1).toDouble())).toInt()
            })
            k++
        }
        return ans
    }
}