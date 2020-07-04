package leetcode.contest.cur.cf653

fun main(args: Array<String>) {
    val (n, m, k) = readLine()!!.split(" ").map { it.toInt() }
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
    val a3 = arrayListOf<Int>()

    val indexMap = HashMap<String, Int>()
    var a0i = 0
    var a1i = 0
    var a2i = 0
    var a3i = 0

    for (i in 0 until n) {
        if (b[i] == 1 && a[i] == 1) {
            a2.add(sp[i])
            indexMap["a2$a2i"] = i
            a2i++
        } else if (b[i] == 1 && a[i] != 1) {
            a1.add(sp[i])
            indexMap["a2$a1i"] = i
            a1i++
        } else if (b[i] != 1 && a[i] == 1) {
            a0.add(sp[i])
            indexMap["a2$a0i"] = i
            a0i++
        } else if (b[i] == 0 && a[i] == 0) {
            a3.add(sp[i])
            indexMap["a3$a3i"] = i
            a3i++
        }
    }
    a0.sort()
    a1.sort()
    a2.sort()
    a3.sort()

    // t0 == t1
    // t0 + t2 >= k
    // 2t0 + t2 + t3 == m
//    println("$m $k   ${a0.size}, ${a1.size}, ${a2.size}, ${a3.size}")
    var ans = Long.MAX_VALUE
    var list = arrayListOf<Int>()
    for (i in 0..a0.size) {
        for (j in 0..a1.size) {
            for (o in 0..a2.size) {
                for (t in 0..a3.size) {
                    if (i + o >= k && j + o >= k && i + j + t + o == m) {
                        val tmpList = arrayListOf<Int>()
                        var tmp = 0L
//                        println("ans $m $k   $i, $j, $o, $t")
                        for (c in 0 until i) {
                            tmp += a0[c]
                            tmpList.add(indexMap["a0${c}"]!!)
                        }
                        for (c in 0 until j) {
                            tmp += a1[c]
                            tmpList.add(indexMap["a1${1}"]!!)
                        }
                        for (c in 0 until o) {
                            tmp += a2[c]
                            tmpList.add(indexMap["a2${2}"]!!)
                        }
                        for (c in 0 until t) {
                            tmp += a3[c]
                            tmpList.add(indexMap["a3${3}"]!!)
                        }
                        if (tmp < ans) {
                            list = tmpList
                        }
                        ans = minOf(ans, tmp)
                    }
                }
            }
        }
    }
    if (ans == Long.MAX_VALUE) println(-1)
    else {
        println(ans)
        println(list.joinToString(" "))
    }
}