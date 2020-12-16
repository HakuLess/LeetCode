package leetcode.normal


// todo not finish
class Solution738 {
    fun monotoneIncreasingDigits(N: Int): Int {
        val arr = N.toString().toCharArray()
        var i = 1
        while (i < arr.size && arr[i - 1] <= arr[i]) {
            i += 1
        }
        if (i < arr.size) {
            while (i > 0 && arr[i - 1] > arr[i]) {
                arr[i - 1] = arr[i - 1] - 1
                i -= 1
            }
            i += 1
            while (i < arr.size) {
                arr[i] = '9'
                ++i
            }
        }
        return String(arr).toInt()
    }
}