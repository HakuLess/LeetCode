package leetcode.normal

// todo
// TAG: 质数
class Solution762 {
    fun countPrimeSetBits(L: Int, R: Int): Int {
        var ans = 0
        for (i in L..R) {
            if (isPrime(Integer.toBinaryString(i).count { it == '1' })) {
                ans++
            }
        }
        return ans
    }

    private fun isPrime(n: Int): Boolean {
        if (n == 1) {
            return false
        }
        if (n == 2) {
            return true
        }
        val j = getMaxInt(n)
        for (i in 2..j) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }

    private fun getMaxInt(n: Int): Int {
        var result = 1
        while (result * result < n) {
            result++
        }
        return result
    }
}