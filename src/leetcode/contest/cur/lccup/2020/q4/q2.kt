package leetcode.contest.cur.`2020`.q4

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solutionq2()
    s.isMagic(intArrayOf(2, 4, 3, 1, 5)).print()
    s.isMagic(intArrayOf(2, 4, 3, 1, 5, 6)).print()
    s.isMagic(intArrayOf(2, 4, 3, 1, 5, 6, 7)).print()
    s.isMagic(intArrayOf(2, 4, 3, 1, 5, 6, 7, 8)).print()
    s.isMagic(intArrayOf(5, 4, 3, 2, 1)).print()
}

class Solutionq2 {
    fun isMagic(target: IntArray): Boolean {
        val n = target.size
        val l = arrayListOf<Int>()
        val r = arrayListOf<Int>()
        val cur = arrayListOf<Int>()
        for (i in 1..n) {
            if (i % 2 == 0) l.add(i)
            else r.add(i)
        }
        cur.addAll(l)
        cur.addAll(r)
        var maxK = 0
        for (i in target.indices) {
            if (cur[i] == target[i]) {
                maxK = i + 1
            } else {
                break
            }
        }
        if (maxK == 0) return false

        fun dfs(k: Int): Boolean {
            var i = 0
            while (cur.isNotEmpty()) {
                for (t in 0 until k) {
                    if (cur.isEmpty()) return true
                    if (cur[0] == target[i]) {
                        cur.removeAt(0)
                    } else {
                        return false
                    }
                    i++
                }
                val l = arrayListOf<Int>()
                val r = arrayListOf<Int>()
                for (j in cur.indices) {
                    if (j % 2 == 0) {
                        r.add(cur[j])
                    } else {
                        l.add(cur[j])
                    }
                }
                cur.clear()
                cur.addAll(l)
                cur.addAll(r)
            }
            return true
        }

        if (dfs(maxK)) {
            return true
        }
        return false
    }
}