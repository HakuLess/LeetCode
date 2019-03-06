package leetcode

fun main(args: Array<String>) {
    val s = Solution969()
    s.pancakeSort(intArrayOf(3, 2, 4, 1)).forEach {
        print("$it, ")
    }
}

class Solution969 {
    fun pancakeSort(A: IntArray): List<Int> {
        val cur = ArrayList<Int>()
        A.forEach {
            cur.add(it)
        }

        val ans = arrayListOf<Int>()
        var end = cur.lastIndex
        while (end >= 0) {
            println("$end ${cur[end]} ${cur.size}")
            if (cur[end] == cur.size) {
                end--
                cur.removeAt(cur.lastIndex)
            } else {
                val maxIndex = cur.indexOf(cur.max())
                ans.add(maxIndex + 1)
                ans.add(cur.size)
                cur.subList(0, maxIndex + 1).reverse()

                cur.forEach {
                    print("$it, ")
                }
                println(" cur before")

                cur.reverse()

                cur.forEach {
                    print("$it, ")
                }
                println(" cur after")
            }
        }
        return ans
    }
}