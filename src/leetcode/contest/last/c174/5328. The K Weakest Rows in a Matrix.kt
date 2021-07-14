package leetcode.contest.last.c174

class Solution5328 {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        return mat.mapIndexed { index, arr -> Pair(index, arr) }
            .sortedWith(compareBy({ it.second.sum() }, { it.first })).take(k).map { it.first }.toIntArray()
    }
}