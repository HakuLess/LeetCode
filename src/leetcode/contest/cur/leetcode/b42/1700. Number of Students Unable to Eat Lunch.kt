package leetcode.contest.cur.leetcode.b42

class Solution1700 {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        val cur = ArrayList(students.toList())
        sandwiches.forEach {
            if (it in cur) {
                cur.remove(it)
            } else {
                return cur.size
            }
        }
        return 0
    }
}