package leetcode.contest.cur.leetcode.b37

import leetcode.contest.utils.inv

class Fancy() {

    var l = arrayListOf<Long>()
    val add = arrayListOf<Long>()
    val mul = arrayListOf<Long>()
    val mod = 1000000007L

    init {
        add.add(0L)
        mul.add(1L)
    }

    fun append(`val`: Int) {
        l.add(`val`.toLong())
        add.add(add[0])
        mul.add(mul[0])
    }

    fun addAll(inc: Int) {
        add[0] = (add[0] + inc) % mod
    }

    fun multAll(m: Int) {
        add[0] = (add[0] * m) % mod
        mul[0] = (mul[0] * m) % mod
    }

    fun getIndex(idx: Int): Int {
        if (idx !in l.indices) return -1
        val mul = mul[0] * inv(mul[idx + 1]) % mod
        val inc = (add[0] - (add[idx + 1] * mul) + mod) % mod
        return ((l[idx] * mul + inc + mod) % mod).toInt()
    }

}