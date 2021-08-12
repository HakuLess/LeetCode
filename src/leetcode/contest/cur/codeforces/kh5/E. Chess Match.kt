package leetcode.contest.cur.codeforces.kh5

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    repeat(t) {
        readLine()
        val a = readLine()!!.split(" ").map { it.toInt() }
        val b = readLine()!!.split(" ").map { it.toInt() }

        val min = minOf(a.minOrNull()!!, b.minOrNull()!!)
        val max = maxOf(a.maxOrNull()!!, b.maxOrNull()!!)

        fun checkMid(mid: Int): Boolean {
            val aa = ArrayList(a.sorted())
            val bb = ArrayList(b.sorted())
            while (aa.isNotEmpty() && bb.isNotEmpty()) {
                return if (aa.first() < bb.first()) {
                    val index = bb.indexOfFirst { it >= aa.first() + mid }
                    if (index >= 0) {
                        aa.removeAt(0)
                        bb.removeAt(index)
                        continue
                    }
                    false
                } else {
                    val index = aa.indexOfFirst { it >= bb.first() + mid }
                    if (index >= 0) {
                        bb.removeAt(0)
                        aa.removeAt(index)
                        continue
                    }
                    false
                }
            }
            return true
        }

        var left = 0
        var right = max - min
        while (left + 1 < right) {
            val mid = (left + right).ushr(1)
            when {
                checkMid(mid) -> left = mid
                else -> right = mid
            }
        }

        val mid = if (checkMid(right)) right else left
//        println("mid is $mid")

        val aa = ArrayList<Pair<Int, Int>>()
        val bb = ArrayList<Pair<Int, Int>>()
        for (i in a.indices) {
            aa.add(Pair(a[i], i + 1))
        }
        for (i in b.indices) {
            bb.add(Pair(b[i], i + 1))
        }
        aa.sortBy { it.first }
        bb.sortBy { it.first }

        val ans = IntArray(aa.size + 1)
        while (aa.isNotEmpty() && bb.isNotEmpty()) {
            if (aa.first().first < bb.first().first) {
                val index = bb.indexOfFirst { it.first >= aa.first().first + mid }
                if (index >= 0) {
                    ans[aa.first().second] = bb[index].second
                    aa.removeAt(0)
                    bb.removeAt(index)
                    continue
                }
            } else {
                val index = aa.indexOfFirst { it.first >= bb.first().first + mid }
                if (index >= 0) {
                    ans[aa[index].second] = bb.first().second
                    bb.removeAt(0)
                    aa.removeAt(index)
                    continue
                }
            }
        }
        println(ans.joinToString(" ").drop(2))
    }
}