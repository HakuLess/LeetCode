package leetcode.normal

class Solution66 {
    fun plusOne(digits: IntArray): IntArray {
        if (digits.all { it == 9 }) {
            val result = IntArray(digits.size + 1)
            result[0] = 1
            return result
        }

        for (i in digits.size - 1 downTo 0) {
            digits[i] += 1
            if (digits[i] == 10) {
                digits[i] = 0
            } else {
                return digits
            }
        }

        return intArrayOf()
    }
}