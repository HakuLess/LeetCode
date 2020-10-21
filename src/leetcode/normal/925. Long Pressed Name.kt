package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution925()
//    s.isLongPressedName("alex", "aaleex").print()
//    s.isLongPressedName("pyplrz", "ppyypllr").print()
//    s.isLongPressedName("saeed", "ssaaedd").print()
    s.isLongPressedName("vtkgn", "vttkgnn").print()
}

class Solution925 {
    fun isLongPressedName(name: String, typed: String): Boolean {
        var i = 0
        var j = 0
        while (i in name.indices) {
            when {
                j !in typed.indices -> return false
                name[i] == typed[j] -> {
                    i++
                    j++
                }
                j == 0 -> {
                    return false
                }
                typed[j] == typed[j - 1] -> {
                    j++
                }
                else -> {
                    return false
                }
            }
        }
        while (j in typed.indices) {
            if (typed[j] != typed[j - 1]) {
                return false
            }
            j++
        }
        return true
    }
}