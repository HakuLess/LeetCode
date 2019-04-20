package leetcode.normal

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return arrayListOf()
    }

    var x = 0
    var y = 0
    val ans = arrayListOf<Int>()
    val n = matrix.size
    val m = matrix[0].size
    var orientation = "right"
    val hashSet = hashSetOf<Pair<Int, Int>>()

    for (i in 0 until n * m) {
        ans.add(matrix[x][y])
        hashSet.add(Pair(x, y))
        when (orientation) {
            "right" -> {
                if (y + 1 < m && Pair(x, y + 1) !in hashSet) {
                    y++
                } else {
                    orientation = "down"
                    x++
                }
            }
            "down" -> {
                if (x + 1 < n && Pair(x + 1, y) !in hashSet) {
                    x++
                } else {
                    orientation = "left"
                    y--
                }
            }
            "left" -> {
                println("$x, $y    ${matrix[x][y]}  ${Pair(x - 1, y) !in hashSet}")
                if (y - 1 >= 0 && Pair(x, y - 1) !in hashSet) {
                    y--
                } else {
                    orientation = "top"
                    x--
                }
            }
            "top" -> {
                if (x - 1 >= 0 && Pair(x - 1, y) !in hashSet) {
                    x--
                } else {
                    orientation = "right"
                    y++
                }
            }
            else -> {
            }
        }
    }
    return ans
}