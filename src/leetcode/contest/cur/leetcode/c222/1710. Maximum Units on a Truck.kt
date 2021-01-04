package leetcode.contest.cur.leetcode.c222

class Solution1710 {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        boxTypes.sortBy { -it[1] }
        var cur = truckSize
        var i = 0
        var ans = 0
        while (cur != 0 && i in boxTypes.indices) {
            val count = minOf(boxTypes[i][0], cur)
            ans += boxTypes[i][1] * count
            cur -= count
            i++
        }
        return ans
    }
}