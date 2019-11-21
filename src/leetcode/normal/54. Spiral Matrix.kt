package leetcode.normal

class Solution54 {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val ans = arrayListOf<Int>()
        if (matrix.isEmpty()) return ans
        val m = matrix.size
        val n = matrix[0].size
        val seen = Array(m) { BooleanArray(n) }
        val dr = intArrayOf(0, 1, 0, -1)
        val dc = intArrayOf(1, 0, -1, 0)
        var r = 0
        var c = 0
        var di = 0
        for (i in 0 until m * n) {
            ans.add(matrix[r][c])
            seen[r][c] = true
            val cr = r + dr[di]
            val cc = c + dc[di]
            if (cr in 0 until m && cc in 0 until n && !seen[cr][cc]) {
                r = cr
                c = cc
            } else {
                di = (di + 1) % 4
                r += dr[di]
                c += dc[di]
            }
        }
        return ans
    }

//    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
//        if (matrix.isEmpty() || matrix[0].isEmpty()) {
//            return arrayListOf()
//        }
//
//        var x = 0
//        var y = 0
//        val ans = arrayListOf<Int>()
//        val n = matrix.size
//        val m = matrix[0].size
//        var orientation = "right"
//        val hashSet = hashSetOf<Pair<Int, Int>>()
//
//        for (i in 0 until n * m) {
//            ans.add(matrix[x][y])
//            hashSet.add(Pair(x, y))
//            when (orientation) {
//                "right" -> {
//                    if (y + 1 < m && Pair(x, y + 1) !in hashSet) {
//                        y++
//                    } else {
//                        orientation = "down"
//                        x++
//                    }
//                }
//                "down" -> {
//                    if (x + 1 < n && Pair(x + 1, y) !in hashSet) {
//                        x++
//                    } else {
//                        orientation = "left"
//                        y--
//                    }
//                }
//                "left" -> {
//                    println("$x, $y    ${matrix[x][y]}  ${Pair(x - 1, y) !in hashSet}")
//                    if (y - 1 >= 0 && Pair(x, y - 1) !in hashSet) {
//                        y--
//                    } else {
//                        orientation = "top"
//                        x--
//                    }
//                }
//                "top" -> {
//                    if (x - 1 >= 0 && Pair(x - 1, y) !in hashSet) {
//                        x--
//                    } else {
//                        orientation = "right"
//                        y++
//                    }
//                }
//                else -> {
//                }
//            }
//        }
//        return ans
//    }
}
