package leetcode.contest.cur.leetcode.b52

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5744()
//    s.rotateTheBox(arrayOf(
//            charArrayOf('#', '.', '#')
//    )).print()
    s.rotateTheBox(arrayOf(
            charArrayOf('#', '.', '#', '.'),
            charArrayOf('#', '#', '*', '.')
    )).print()
}

class Solution5744 {
    fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
        val n = box.size
        val m = box[0].size

//        box.print()
        for (i in 0 until n) {
            val tmp = arrayListOf<Int>()
            for (j in m - 1 downTo 0) {
                if (box[i][j] == '.') {
                    tmp.add(j)
                } else if (box[i][j] == '*') {
                    tmp.clear()
                } else if (box[i][j] == '#') {
                    if (tmp.isNotEmpty()) {
                        box[i][tmp.first()] = '#'
                        box[i][j] = '.'
                        tmp.add(j)
                        tmp.removeAt(0)
                    }
                }
            }
        }

        val ans = Array<CharArray>(m) { CharArray(n) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                ans[j][i] = box[i][j]
            }
        }

        return ans.map { it.reversed().toCharArray() }.toTypedArray()
    }
}