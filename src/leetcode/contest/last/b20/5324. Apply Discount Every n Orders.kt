package leetcode.contest.last.b20

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val cashier = Cashier(3, 50, intArrayOf(1, 2, 3, 4, 5, 6, 7), intArrayOf(100, 200, 300, 400, 300, 200, 100))
    cashier.getBill(intArrayOf(1, 2), intArrayOf(1, 2)).print()                        // 返回 500.0, 账单金额为 = 1 * 100 + 2 * 200 = 500.
    cashier.getBill(intArrayOf(3, 7), intArrayOf(10, 10)).print()                        // 返回 500.0, 账单金额为 = 1 * 100 + 2 * 200 = 500.
    cashier.getBill(intArrayOf(1,2,3,4,5,6,7), intArrayOf(1,1,1,1,1,1,1)).print()                        // 返回 500.0, 账单金额为 = 1 * 100 + 2 * 200 = 500.
//    cashier.getBill([3,7],[10,10]);                      // 返回 4000.0
//    cashier.getBill([1,2,3,4,5,6,7],[1,1,1,1,1,1,1]);    // 返回 800.0 ，账单原本为 1600.0 ，但由于该顾客是第三位顾客，他将得到 50% 的折扣，所以实际金额为 1600 - 1600 * (50 / 100) = 800 。
//    cashier.getBill([4],[10]);                           // 返回 4000.0
//    cashier.getBill([7,3],[10,10]);                      // 返回 4000.0
//    cashier.getBill([7,5,3,1,6,4,2],[10,10,10,9,9,9,7]); // 返回 7350.0 ，账单原本为 14700.0 ，但由于系统计数再次达到三，该顾客将得到 50% 的折扣，实际金额为 7350.0 。
//    cashier.getBill([2,3,5],[5,3,2]);
}

class Cashier(val n: Int, discount: Int, products: IntArray, prices: IntArray) {

    private val map = HashMap<Int, Double>()

    private val dis = 1.00 - discount.toDouble() / 100

    init {
        for (i in products.indices) {
            map[products[i]] = prices[i].toDouble()
        }
    }

    var cur = 0

    fun getBill(product: IntArray, amount: IntArray): Double {
        cur++
        var ans = 0.0
        for (i in product.indices) {
            ans += map[product[i]]!! * amount[i]
        }
        if (cur == n) {
            cur = 0
            ans *= dis
        }
        return ans
    }

}

/**
 * Your Cashier object will be instantiated and called as such:
 * var obj = Cashier(n, discount, products, prices)
 * var param_1 = obj.getBill(product,amount)
 */