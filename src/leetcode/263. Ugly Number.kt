package leetcode

class Solution263 {
    fun isUgly(num: Int): Boolean {
        if (num <= 0) {
            return false
        }
        var temp = num
        var flag = true
        while (flag) {
            println(temp)
            when {
                temp % 2 == 0 -> temp /= 2
                temp % 3 == 0 -> temp /= 3
                temp % 5 == 0 -> temp /= 5
            }
            if (temp % 2 != 0 && temp % 3 != 0 && temp % 5 != 0) {
                flag = false
            }
        }
        return temp == 1
    }
}