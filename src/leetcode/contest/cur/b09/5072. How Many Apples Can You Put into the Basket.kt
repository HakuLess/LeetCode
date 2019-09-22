package leetcode.contest.cur.b09

class Solution5072 {
    fun maxNumberOfApples(arr: IntArray): Int {
        arr.sort()
        var ans = 0
        var sum = 0
        for (i in 0 until arr.size) {
            sum += arr[i]
            if (sum <= 5000) {
                ans++
            } else {
                return ans
            }
        }
        return ans
    }
}