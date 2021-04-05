package leetcode.contest.cur.`2020`.q2

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solutionq6()
//    s.maxWeight(arrayOf(
//            intArrayOf(0, 1),
//            intArrayOf(1, 2),
//            intArrayOf(0, 2)
//    ), intArrayOf(1, 2, 3)).print()

//    s.maxWeight(arrayOf(
//            intArrayOf(0, 2),
//            intArrayOf(2, 1)
//    ), intArrayOf(1, 2, 5)).print()

    s.maxWeight(arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3),
            intArrayOf(0, 4),
            intArrayOf(0, 5),
            intArrayOf(1, 3),
            intArrayOf(2, 4),
            intArrayOf(2, 5),
            intArrayOf(3, 4),
            intArrayOf(3, 5),
            intArrayOf(4, 5)
    ), intArrayOf(7, 8, 6, 8, 9, 7)).print()
}

class Solutionq6 {
    fun maxWeight(edges: Array<IntArray>, value: IntArray): Int {
        val map = HashMap<Int, ArrayList<Int>>()
        var n = 0
        edges.forEach {
            map[it[0]] = map.getOrDefault(it[0], arrayListOf())
            map[it[0]]!!.add(it[1])
            map[it[1]] = map.getOrDefault(it[1], arrayListOf())
            map[it[1]]!!.add(it[0])
            n = maxOf(n, it[0])
            n = maxOf(n, it[1])
        }

        var ans = 0
        for (i in 0 until n) {
            ans = maxOf(ans, getMax(i, map, value))
        }
        return ans
    }

    private fun isAva(c: Int, map: HashMap<Int, ArrayList<Int>>): ArrayList<IntArray> {
        val ans = ArrayList<IntArray>()
        val cur = map.getOrDefault(c, arrayListOf())
        for (i in 0 until cur.lastIndex) {
            for (j in i + 1..cur.lastIndex) {
                if (map[cur[j]]?.contains(cur[i]) == true) {
                    ans.add(intArrayOf(c, cur[i], cur[j]))
                }
            }
        }
        return ans
    }

    private fun getMax(c: Int, map: HashMap<Int, ArrayList<Int>>, value: IntArray): Int {
        val l = isAva(c, map)
        var ans = 0
        for (i in l.indices) {
            for (j in l.indices) {
                val set = l[i].toHashSet()
                set.addAll(l[j].toList())
                var cur = 0
                set.forEach {
                    cur += value[it]
                }
                ans = maxOf(cur, ans)
            }
        }
        return ans
    }
}