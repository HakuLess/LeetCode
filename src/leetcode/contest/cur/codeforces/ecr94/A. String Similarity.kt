package leetcode.contest.cur.codeforces.ecr94

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (c in 0 until t) {
        val n = readLine()!!.toInt()
        val s = readLine().toString()
        val ans = s.substring(IntRange(0, n - 1)).toCharArray()
        val list = ArrayList<CharArray>()
        for (i in s.indices) {
            if (n + i > s.length) break
            val cur = s.substring(IntRange(i, n + i - 1))
            list.add(cur.toCharArray())
        }
        var index = 0
        while (list.isNotEmpty()) {
            var a = 0
            var b = 0
            list.forEach {
                if (it[index] == '0') {
                    a++
                } else {
                    b++
                }
            }
            if (a > b) {
                ans[index] = '0'
                list.removeAll { it[index] == '0' }
            } else {
                ans[index] = '1'
                list.removeAll { it[index] == '1' }
            }
            index++
        }
        println(ans.joinToString(""))
    }
}