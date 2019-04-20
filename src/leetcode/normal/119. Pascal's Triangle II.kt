package leetcode.normal

fun getRow(rowIndex: Int): List<Int> {
    when (rowIndex) {
        0 -> return arrayListOf(1)
        1 -> return arrayListOf(1, 1)
        else -> {
            val lines = getRow(rowIndex - 1)
            val result = arrayListOf<Int>()
            lines.forEachIndexed { index, i ->
                if (index == 0) {
                    result.add(i)
                } else {
                    result.add(i + lines[index - 1])
                }

                if (index == lines.size - 1) {
                    result.add(i)
                }
            }
            return result
        }
    }
}