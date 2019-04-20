package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution925()
    s.isLongPressedName("alex", "aaleex").print()
    s.isLongPressedName("pyplrz", "ppyypllr").print()
}

class Solution925 {

    fun isLongPressedName(name: String, typed: String): Boolean {
        var right = 0
        var left = 0
        while (left < name.length) {
            if (right >= typed.length) {
                return false
            } else if (name[left] == typed[right]) {
                right++
                left++
            } else if (right > 0 && typed[right] == typed[right - 1]) {
                right++
                continue
            } else {
                return false
            }
        }

        for (i in right until typed.length) {
            if (typed[i] != typed[right - 1]) {
                return false
            }
        }
        return true
    }
}