package leetcode.contest.cur.leetcode.b36

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5516()
//    s.alertNames(arrayOf("daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"),
//            arrayOf("10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00")).joinToString(", ").print()

    s.alertNames(arrayOf("leslie","leslie","leslie","clare","clare","clare","clare"),
            arrayOf("13:00","13:20","14:00","18:00","18:51","19:30","19:49")).joinToString(", ").print()
}

class Solution5516 {
    fun alertNames(keyName: Array<String>, keyTime: Array<String>): List<String> {
        val map = HashMap<String, ArrayList<Int>>()
        for (i in keyName.indices) {
            val cur = map.getOrDefault(keyName[i], arrayListOf())
            val times = keyTime[i].split(":").map { it.toInt() }
            cur.add(times[0] * 60 + times[1])
            map[keyName[i]] = cur
        }
        val ans = ArrayList<String>()
        map.forEach { (s, it) ->
            val arr = it.sorted()
            if (arr.size >= 3) {
                for (i in 0 until arr.size - 2) {
                    println(arr[i + 2] - arr[0])
                    if (arr[i + 2] - arr[i] <= 60) {
                        ans.add(s)
                    }
                }
            }
        }
        return ans.distinct().sorted()
    }
}