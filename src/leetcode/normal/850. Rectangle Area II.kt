package leetcode.normal

import java.util.ArrayList
import kotlin.math.max
import kotlin.math.min

// todo Study
class Solution850 {

    fun rectangleArea(rectangles: Array<IntArray>): Int {
        val mod = 1000000007
        var res: Long = 0
        val recList = ArrayList<IntArray>()
        for (rec in rectangles)
            addRectangle(recList, rec, 0)

        for (rec in recList)
            res = (res + (rec[2] - rec[0]).toLong() * (rec[3] - rec[1]).toLong()) % mod

        return res.toInt() % mod
    }

    private fun addRectangle(recList: ArrayList<IntArray>, curRec: IntArray, start: Int) {
        if (start >= recList.size) {
            recList.add(curRec)
            return
        }

        val r = recList[start]

        // No overlap
        if (curRec[2] <= r[0] || curRec[3] <= r[1] || curRec[0] >= r[2] || curRec[1] >= r[3]) {
            addRectangle(recList, curRec, start + 1)
            return
        }

        if (curRec[0] < r[0])
            addRectangle(recList, intArrayOf(curRec[0], curRec[1], r[0], curRec[3]), start + 1)

        if (curRec[2] > r[2])
            addRectangle(recList, intArrayOf(r[2], curRec[1], curRec[2], curRec[3]), start + 1)

        if (curRec[1] < r[1])
            addRectangle(recList, intArrayOf(max(r[0], curRec[0]), curRec[1], min(r[2], curRec[2]), r[1]), start + 1)

        if (curRec[3] > r[3])
            addRectangle(recList, intArrayOf(max(r[0], curRec[0]), r[3], min(r[2], curRec[2]), curRec[3]), start + 1)
    }
}