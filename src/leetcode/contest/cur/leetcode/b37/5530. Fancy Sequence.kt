package leetcode.contest.cur.leetcode.b37

import java.math.BigInteger


class Fancy() {

    var l = arrayListOf<Long>()
    val add = arrayListOf<BigInteger>()
    val mul = arrayListOf<BigInteger>()
    val mod = 1000000007L.toBigInteger()

    init {
        add.add(0L.toBigInteger())
        mul.add(1L.toBigInteger())
    }

    fun append(`val`: Int) {
        l.add(`val`.toLong())
        add.add(add[0])
        mul.add(mul[0])
    }

    fun addAll(inc: Int) {
        add[0] = (add[0] + inc.toBigInteger())
    }

    fun multAll(m: Int) {
        add[0] = (add[0] * m.toBigInteger())
        mul[0] = (mul[0] * m.toBigInteger())
    }

    fun getIndex(idx: Int): Int {
        if (idx !in l.indices) return -1
        val mul = mul[0] / mul[idx + 1]
        val inc = add[0] - (add[idx + 1] * mul)
        return ((l[idx].toBigInteger() * mul + inc) % mod).toInt()
    }

}