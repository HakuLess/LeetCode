package leetcode.contest.cur.cf653

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val a = IntArray(n)
    val b = IntArray(n)
    val sp = IntArray(n)
    for (i in 0 until n) {
        val (t, ai, bi) = readLine()!!.split(" ").map { it.toInt() }
        sp[i] = t
        b[i] = bi
        a[i] = ai
    }
    val a0 = arrayListOf<Int>()
    val a1 = arrayListOf<Int>()
    val a2 = arrayListOf<Int>()
    for (i in 0 until n) {
        if (b[i] == 1 && a[i] == 1) {
            a2.add(sp[i])
        } else if (b[i] == 1 && a[i] != 1) {
            a1.add(sp[i])
        } else if (b[i] != 1 && a[i] == 1) {
            a0.add(sp[i])
        }
    }
    a0.sort()
    a1.sort()
    a2.sort()
    if (a0.size + a2.size < k || a1.size + a2.size < k) {
        println(-1)
        return
    }

    var t0 = 0
    var t1 = 0
    var cur = 0
    var ans = 0L
    while (cur != k) {
        if (t0 !in a0.indices || t0 !in a1.indices) {
            ans += a2[t1]
            cur++
            t1++
        } else if (t1 !in a2.indices) {
            ans += a0[t0] + a1[t0]
            cur++
            t0++
        } else if (a0[t0] + a1[t0] <= a2[t1]) {
            ans += a0[t0] + a1[t0]
            cur++
            t0++
        } else {
            ans += a2[t1]
            cur++
            t1++
        }
    }
    println(ans)
}