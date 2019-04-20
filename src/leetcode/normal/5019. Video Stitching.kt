package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution5019()
    s.videoStitching(
            arrayOf(intArrayOf(0, 1),
                    intArrayOf(1, 2))
            , 5
    ).print()

    s.videoStitching(
            arrayOf(intArrayOf(0, 2),
                    intArrayOf(4, 7),
                    intArrayOf(8, 10),
                    intArrayOf(1, 9),
                    intArrayOf(1, 5),
                    intArrayOf(5, 9)
            )
            , 10
    ).print()

    s.videoStitching(
            arrayOf(intArrayOf(0, 4),
                    intArrayOf(2, 8)
            )
            , 5
    ).print()
}

class Solution5019 {
    fun videoStitching(clips: Array<IntArray>, T: Int): Int {
        clips.sortWith(compareBy({ it[0] }, { -it[1] }))
        if (clips[0][0] != 0) {
            return -1
        }

        var max = T + 1
        clips.forEach {
            max = maxOf(it[1] + 1, max)
        }
        val ans = IntArray(max) { 1000 }
        ans[0] = 0

        clips.forEach {
            for (i in it[0]..it[1]) {
                ans[i] = minOf(ans[i], ans[it[0]] + 1)
            }
        }

        ans.print()
        return if (ans[T] == 1000) {
            -1
        } else {
            ans[T]
        }
    }
}