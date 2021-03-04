package leetcode.normal

class Solution338 {
    fun countBits(num: Int): IntArray {
        val arr = IntArray(num + 1)
        arr[0] = 0
        for (i in 1..num) {
            if (i % 2 == 1) {
                arr[i] = arr[i - 1] + 1
            } else {
                arr[i] = arr[i / 2]
            }
        }
        return arr
    }
}