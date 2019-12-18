package leetcode.normal

fun main(args: Array<String>) {
    val s = Solution119()
    s.getRow(5).forEach {
        print("$it, ")
    }
}

class Solution119 {
    fun getRow(rowIndex: Int): List<Int> {
        val cur = ArrayList<Int>()
        cur.add(1)
        for (i in 1..rowIndex) {
            for (j in i - 1 downTo 1) {
                cur[j] = cur[j] + cur[j - 1]
            }
            cur.add(1)
        }
        return cur
    }
//    fun getRow(rowIndex: Int): List<Int> {
//        when (rowIndex) {
//            0 -> return arrayListOf(1)
//            1 -> return arrayListOf(1, 1)
//            else -> {
//                val lines = getRow(rowIndex - 1)
//                val result = arrayListOf<Int>()
//                lines.forEachIndexed { index, i ->
//                    if (index == 0) {
//                        result.add(i)
//                    } else {
//                        result.add(i + lines[index - 1])
//                    }
//
//                    if (index == lines.size - 1) {
//                        result.add(i)
//                    }
//                }
//                return result
//            }
//        }
//    }
}