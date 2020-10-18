package leetcode.normal


class Solution621 {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val arrays = IntArray(26)
        tasks.forEach {
            arrays[it - 'A']++
        }
        arrays.sortDescending()
        var result = 0
        val c = arrays.count {
            it != 0
        }
        var offset = 1
        var t = 1
        while (t < 26 && arrays[t] == arrays[t - 1]) {
            offset++
            t++
        }
        val max = arrays[0]
        if (c <= n + 1) {
            result = (max - 1) * (n + 1) + offset
        } else if (c > n) {
            var first = 0
            for (i in 0..n) {
                first += arrays[i]
            }
            var second = 0
            for (i in (n + 1)..25) {
                second += arrays[i]
            }
            result = if (first + second < max * (n + 1)) {
                (max - 1) * (n + 1) + offset
            } else {
                first + second
            }
        }
        return result
    }
}