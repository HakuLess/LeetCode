package leetcode.contest.cur.atcoder.abc188

fun main(args: Array<String>) {
    readLine()
    val arr = readLine()!!.split(' ').map { it.toInt() }
    val a = ArrayList(arr)
    while (a.size != 2) {
        for (i in a.indices.reversed() step 2) {
            if (a[i] > a[i - 1])
                a.removeAt(i - 1)
            else
                a.removeAt(i)
        }
    }
    println(arr.indexOf(a.min()!!) + 1)
}