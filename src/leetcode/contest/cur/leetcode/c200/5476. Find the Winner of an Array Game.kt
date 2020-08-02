package leetcode.contest.cur.leetcode.c200

class Solution5476 {
    fun getWinner(arr: IntArray, k: Int): Int {
        if (k > arr.size) return arr.max()!!
        val l = ArrayList<Int>()
        l.addAll(arr.toList())
        var cur = 0
        while (cur != k) {
            if (l[0] > l[1]) {
                cur++
                val temp = l[1]
                l.removeAt(1)
                l.add(temp)
            } else {
                cur = 1
                val temp = l[0]
                l.removeAt(0)
                l.add(temp)
            }
        }
        return l[0]
    }
}