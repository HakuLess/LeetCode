package leetcode.contest.cur.leetcode.b42

import leetcode.contest.utils.toArrayList

class Solution1700 {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        val cur = students.toArrayList()
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