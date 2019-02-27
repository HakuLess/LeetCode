package leetcode

class Solution509 {
    val hashMap = HashMap<Int, Int>()

    fun fib(N: Int): Int {
        if (hashMap.containsKey(N)) {
            return hashMap[N]!!
        }

        return when (N) {
            0 -> 0
            1 -> 1
            else -> {
                fib(N - 1) + fib(N - 2)
            }
        }
    }
}