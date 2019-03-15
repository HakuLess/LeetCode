package leetcode

fun main(args: Array<String>) {
    val s = Solution756()
    s.pyramidTransition("XYZY", listOf("XYD", "YZE", "DEA", "FFF")).print()
}

class Solution756 {
    fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
        var list = List(bottom.length) {
            arrayListOf(bottom[it])
        }

        while (list.size != 1) {
            for (k in 1 until list.size) {
                val ans = arrayListOf<Char>()
                for (i in 0 until list[k - 1].size) {
                    for (j in 0 until list[k].size) {
                        allowed.forEach {
                            if (it[0] == list[k - 1][i] &&
                                    it[1] == list[k][j]) {
                                ans.add(it[2])
                            }
                        }
                    }
                }
                list[k - 1].clear()
                list[k - 1].addAll(ans)
                println(list.lastIndex)
                if (k == list.lastIndex) {
                    list = list.subList(0, list.lastIndex)
                }
            }
        }

        list.forEach {
            it.forEach {
                print("$it, ")
            }
            println()
        }

        return true
    }
}