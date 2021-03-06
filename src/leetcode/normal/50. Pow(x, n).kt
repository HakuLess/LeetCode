package leetcode.normal

class Solution50 {
//    fun myPow(x: Double, n: Int): Double {
//        return x.pow(n.toDouble())
//    }

    fun quickMul(x: Double, n: Long): Double {
        if (n == 0L) {
            return 1.0
        }
        val y = quickMul(x, n / 2)
        return if (n % 2 == 0L) y * y else y * y * x
    }

    fun myPow(x: Double, n: Int): Double {
        val N = n.toLong()
        return if (N >= 0) quickMul(x, N) else 1.0 / quickMul(x, -N)
    }
}