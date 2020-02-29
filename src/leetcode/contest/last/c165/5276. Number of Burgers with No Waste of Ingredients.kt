package leetcode.contest.last.c165

fun main(args: Array<String>) {
    val s = Solution5276()
    s.numOfBurgers(16, 7).forEach {
        print("$it, ")
    }
    println()
    s.numOfBurgers(3962, 1205).forEach {
        print("$it, ")
    }
    println()
    s.numOfBurgers(11658, 5228).forEach {
        print("$it, ")
    }
    println()
}

class Solution5276 {
    fun numOfBurgers(tomatoSlices: Int, cheeseSlices: Int): List<Int> {
        var a = tomatoSlices
        var b = cheeseSlices
        if (a == 0 || b == 0) {
            return if (a == 0 && b == 0) {
                listOf(0, 0)
            } else {
                emptyList()
            }
        }
        if (a == 2 && b == 1) {
            return listOf(0, 1)
        }
        if (a.toDouble() / b.toDouble() < 2.0 || a.toDouble() / b.toDouble() > 4.0) {
            return emptyList()
        }
        var left = 0
        var right = b
        while (left + 1 < right) {
            val mid = (left + right).ushr(1)
            when {
                (mid * 4 + (b - mid) * 2 > a) -> right = mid
                (mid * 4 + (b - mid) * 2 == a) -> return listOf(mid, b - mid)
                else -> left = mid
            }
        }
        return emptyList()
    }
}