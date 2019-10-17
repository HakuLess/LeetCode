package leetcode.contest.last.c155

class Solution5197 {
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        arr.sort()
        val ans = arrayListOf<List<Int>>()
        var min = Int.MAX_VALUE
        for (i in 1 until arr.size) {
            if (arr[i] - arr[i - 1] < min) {
                ans.clear()
                min = arr[i] - arr[i - 1]
                ans.add(listOf(arr[i - 1], arr[i]))
            } else if (arr[i] - arr[i - 1] == min) {
                ans.add(listOf(arr[i - 1], arr[i]))
            }
        }
        return ans
    }
}