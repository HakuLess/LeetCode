package leetcode.contest.cur.codeforces.ecr94

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (z in 0 until t) {
        val s = readLine()!!.toString().toCharArray()
        val x = readLine()!!.toInt()
        val ans = CharArray(s.size) { '1' }

        for (i in s.indices) {
            if (s[i] == '0') {
                if (i + x in s.indices) {
                    ans[i + x] = '0'
                }
                if (i - x in s.indices) {
                    ans[i - x] = '0'
                }
            }
        }

        val dc = CharArray(s.size)
        for (i in s.indices) {
            if (i + x in ans.indices && ans[i + x] == '1') {
                dc[i] = '1'
            } else if (i - x in ans.indices && ans[i - x] == '1') {
                dc[i] = '1'
            } else {
                dc[i] = '0'
            }
        }
        if (dc.joinToString("") != s.joinToString("")) {
            println(-1)
        } else
            println(ans.joinToString(""))
    }
}