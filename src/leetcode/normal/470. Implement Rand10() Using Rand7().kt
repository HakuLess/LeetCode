package leetcode.normal

class Solution470 {
    fun rand10(): Int {
        var a: Int
        var b: Int
        var m: Int
        do {
            a = rand7()
            b = rand7()
            m = b + (a - 1) * 7
        } while (m > 40)
        return 1 + (m - 1) % 10
    }

    private fun rand7(): Int {
        return 0
    }
}

