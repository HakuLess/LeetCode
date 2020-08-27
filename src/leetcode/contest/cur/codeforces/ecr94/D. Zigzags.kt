package leetcode.contest.cur.codeforces.ecr94

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (z in 0 until t) {
        val n = readLine()!!.toInt()
        val a = readLine()!!.split(' ').map { it.toInt() }

        val left = IntArray(3001)
        var right = IntArray(3001)

        left[a[0]]++
        var ans = 0L

        for (j in 1 until n - 2) {
            right = IntArray(3001)
            for (k in n - 1 downTo j + 1) {
                ans += left[a[k]] * right[a[j]]
                right[a[k]]++
            }
            left[a[j]]++
        }
        println(ans)
    }
}