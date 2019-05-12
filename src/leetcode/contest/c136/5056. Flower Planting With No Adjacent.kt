package leetcode.contest.c136

fun main(args: Array<String>) {
    val s = Solution5056()
    s.gardenNoAdj(3,
            arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(1, 3)
            )
    ).forEach {
        print("$it, ")
    }
}

class Solution5056 {
    fun gardenNoAdj(N: Int, paths: Array<IntArray>): IntArray {
        val ans = IntArray(N) { 0 }
        ans[0] = 1
        for (i in 2..N) {
            val array = arrayListOf(1, 2, 3, 4)
            paths.filter {
                it[0] == i || it[1] == i
            }.forEach {
                if (it[0] == i && ans[it[1] - 1] != 0) {
                    array.remove(ans[it[1] - 1])
                }

                if (it[1] == i && ans[it[0] - 1] != 0) {
                    array.remove(ans[it[0] - 1])
                }
            }
            println("${i - 1}, ${array.first()}")
            ans[i - 1] = array.first()
        }

        return ans
    }
}