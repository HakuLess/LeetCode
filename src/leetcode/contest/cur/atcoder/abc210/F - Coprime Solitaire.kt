package leetcode.contest.cur.atcoder.abc210

import leetcode.contest.utils.getPrime

// Pair列表，每个位置各选一个数字，能否互相互质
fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val list = arrayListOf<Pair<Int, Int>>()
    repeat(n) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        list.add(Pair(a, b))
    }
    val primes = getPrime(2000005)

    fun dfs(i: Int, cur: HashSet<Int>): Boolean {
        if (i >= n) return true
        val nextL = HashSet(cur)
        val nextR = HashSet(cur)

        val ln = arrayListOf<Int>()
        val rn = arrayListOf<Int>()
        var l = list[i].first
        while (primes[l] != 1) {
            ln.add(primes[l])
            l /= primes[l]
        }
        var r = list[i].second
        while (primes[r] != 1) {
            rn.add(primes[r])
            r /= primes[r]
        }
        var ans = false
        if (nextL.intersect(ln.toSet()).isEmpty()) {
            nextL.addAll(ln)
            ans = ans or dfs(i + 1, nextL)
        }
        if (nextR.intersect(rn.toSet()).isEmpty()) {
            nextR.addAll(rn)
            ans = ans or dfs(i + 1, nextR)
        }
        return ans
    }

    if (dfs(0, hashSetOf())) println("Yes")
    else println("No")
}