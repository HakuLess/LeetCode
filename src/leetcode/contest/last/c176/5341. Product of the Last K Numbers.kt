package leetcode.contest.last.c176

class ProductOfNumbers() {

    val l = ArrayList<Int>()

    fun add(num: Int) {
        l.add(num)
    }

    fun getProduct(k: Int): Int {
        val r = l.reversed()
        var ans = 1
        for (i in 0 until k) {
            ans *= r[i]
        }
        return ans
    }

}