package leetcode.contest.cur.codeforces.ecr94

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()

    fun take(s: Long, w: Long, cs: Long, cw: Long, p: Long): Long {
        if (s > w)
            return take(w, s, cw, cs, p)

        if (s * cs >= p)
            return p / s

        return cs + minOf((p - s * cs) / w, cw)
    }

    for (z in 0 until t) {
        val (p, f) = readLine()!!.split(' ').map { it.toLong() }
        val (cs, cw) = readLine()!!.split(' ').map { it.toLong() }
        val (s, w) = readLine()!!.split(' ').map { it.toLong() }
        var ans = 0L

        for (i in 0..cs) {
            if (i * s <= p) {
                val tw = minOf((p - i * s) / w, cw)
                ans = maxOf(ans, i + tw + take(s, w, cs - i, cw - tw, f))
            }
        }
        println(ans)
    }
}