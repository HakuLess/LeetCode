package leetcode.contest.cur.codeforces.cf664

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        var (r, g, b, w) = readLine()!!.split(' ').map { it.toInt() }
        var ans = 0
        ans += if (r % 2 == 0) 0 else 1
        ans += if (g % 2 == 0) 0 else 1
        ans += if (b % 2 == 0) 0 else 1
        ans += if (w % 2 == 0) 0 else 1
        if (ans <= 1) {
            println("Yes")
            continue
        }
        if (r >= 1 && g >= 1 && b >= 1) {
            ans = 0
            r--
            g--
            b--
            w += 3
            ans += if (r % 2 == 0) 0 else 1
            ans += if (g % 2 == 0) 0 else 1
            ans += if (b % 2 == 0) 0 else 1
            ans += if (w % 2 == 0) 0 else 1
            if (ans <= 1) println("Yes") else println("No")
        } else {
            println("No")
        }
    }
}