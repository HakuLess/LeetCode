package leetcode.contest.last.c191

class Solution5425 {
    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        val mod = 1000000007L
        val a = ArrayList<Int>()
        a.add(0)
        a.addAll(horizontalCuts.toList())
        a.add(h)
        a.sort()

        val b = ArrayList<Int>()
        b.add(0)
        b.addAll(verticalCuts.toList())
        b.add(w)
        b.sort()

        var maxa = 0L
        for (i in a.indices) {
            if (i == 0) continue
            maxa = maxOf(maxa, (a[i] - a[i - 1]).toLong())
            maxa %= mod
        }

        var maxb = 0L
        for (i in b.indices) {
            if (i == 0) continue
            maxb = maxOf(maxb, (b[i] - b[i - 1]).toLong())
            maxb %= mod
        }
        return ((maxa * maxb) % mod).toInt()
    }
}