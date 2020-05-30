package leetcode.contest.cur.b27

class Solution5408 {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        return target.sorted() == arr.sorted()
    }
}