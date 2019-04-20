package leetcode.normal

class Solution638 {

    var total = Integer.MAX_VALUE
    var n = 0

    fun shoppingOffers(price: List<Int>, special: List<List<Int>>, needs: List<Int>): Int {
        n = needs.size
        dfs(price, special, needs, 0)
        return total
    }

    private fun dfs(price: List<Int>, special: List<List<Int>>, needs: List<Int>, sp: Int) {
        for (i in 0 until n) {
            if (needs[i] < 0) {
                return
            }
        }

        // use no special
        var sum = 0
        for (i in 0 until n) {
            sum += price[i] * needs[i]
        }
        total = minOf(total, sum + sp)

        // use special
        special.forEach {
            val left = arrayListOf<Int>()
            for (i in 0 until n) {
                left.add(needs[i] - it[i])
            }
            dfs(price, special, left, sp + it.last())
        }
    }
}