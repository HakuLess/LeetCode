package leetcode.normal

class Solution452 {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        var st = points.sortedBy { it[1] }
        var ans = 0
        while (st.isNotEmpty()) {
            val arr = st[0][1]
            st = st.filter {
                arr !in it[0]..it[1]
            }
            ans++
        }
        return ans
    }
}