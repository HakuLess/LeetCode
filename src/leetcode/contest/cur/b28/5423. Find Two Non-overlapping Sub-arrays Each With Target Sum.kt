package leetcode.contest.cur.b28

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5423()
    s.minSumOfLengths(intArrayOf(3, 2, 2, 4, 3), 3).print()
    s.minSumOfLengths(intArrayOf(3, 1, 1, 1, 5, 1, 2, 1), 3).print()
}

class Solution5423 {
    fun minSumOfLengths(arr: IntArray, target: Int): Int {
        if (arr.all { it == arr[0] }) {
            val ans = target / arr[0] * 2
            return if (ans > arr.size) {
                 -1
            } else {
                ans
            }
        }
        val sum = IntArray(arr.size + 1)
        sum[0] = 0
        for (i in 1..sum.lastIndex) {
            sum[i] = sum[i - 1] + arr[i - 1]
        }
        val map = HashMap<Int, ArrayList<Int>>()
        map[0] = arrayListOf(0)

        for (i in sum.indices) {
            map[sum[i]] = map.getOrDefault(sum[i], arrayListOf())
            map[sum[i]]!!.add(i)
        }

        val l = ArrayList<Pair<Int, Int>>()
        for (i in sum.indices) {
            var ans = -1
            map[sum[i] + target]?.forEach {
                if (it > i) {
                    ans = it
                }
                return@forEach
            }
            if (ans != -1) {
                l.add(Pair(i, ans))
            }
        }

        var ans = Int.MAX_VALUE / 2
        for (i in l.indices) {
            for (j in i + 1..l.lastIndex) {
                if (l[j].first >= l[i].second) {
                    ans = minOf(ans, l[i].second - l[i].first + l[j].second - l[j].first)
                }
            }
        }
        return if (ans == Int.MAX_VALUE / 2) -1 else ans
    }
}