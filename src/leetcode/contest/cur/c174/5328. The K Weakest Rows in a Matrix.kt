package leetcode.contest.cur.c174

class Solution5328 {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val list = ArrayList<Pair<Int, Int>>()
        mat.mapIndexed { index, ints ->
            list.add(Pair(index, ints.sum()))
        }
        return list.sortedBy { it.second }.subList(0, k).map {
            it.first
        }.toIntArray()
    }
}