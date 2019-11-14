package leetcode.normal


class Solution36 {
    //    fun isValidSudoku(board: Array<CharArray>): Boolean {
//        val hashSet = hashSetOf<Char>()
//
//        for (i in 0..8) {
//            hashSet.clear()
//            for (j in 0..8) {
//                if (board[i][j] != '.') {
//                    if (hashSet.contains(board[i][j])) {
//                        return false
//                    } else {
//                        hashSet.add(board[i][j])
//                    }
//                }
//            }
//        }
//
//        for (j in 0..8) {
//            hashSet.clear()
//            for (i in 0..8) {
//                if (board[i][j] != '.') {
//                    if (hashSet.contains(board[i][j])) {
//                        return false
//                    } else {
//                        hashSet.add(board[i][j])
//                    }
//                }
//            }
//        }
//
//        val core = arrayListOf(Pair(1, 1), Pair(1, 4), Pair(1, 7),
//                Pair(4, 1), Pair(4, 4), Pair(4, 7),
//                Pair(7, 1), Pair(7, 4), Pair(7, 7))
//        val dirs = arrayListOf(Pair(-1, -1), Pair(-1, 0), Pair(-1, 1),
//                Pair(0, -1), Pair(0, 0), Pair(0, 1),
//                Pair(1, -1), Pair(1, 0), Pair(1, 1))
//
//        for (item in core) {
//            hashSet.clear()
//            for (dir in dirs) {
//                if (board[item.first + dir.first][item.second + dir.second] != '.') {
//                    if (hashSet.contains(board[item.first + dir.first][item.second + dir.second])) {
//                        return false
//                    } else {
//                        hashSet.add(board[item.first + dir.first][item.second + dir.second])
//                    }
//                }
//            }
//        }
//        return true
//    }

//    fun isValidSudoku(board: Array<CharArray>): Boolean {
//        val map = HashMap<Int, ArrayList<Char>>()
//        board.forEachIndexed { index, chars ->
//            chars.forEachIndexed { i, c ->
//                if (c != '.') {
//                    map[index] = map.getOrDefault(index, arrayListOf())
//                    map[index]?.apply {
//                        if (contains(c)) {
//                            return false
//                        }
//                        add(c)
//                    }
//                    map[10 + i] = map.getOrDefault(10 + i, arrayListOf())
//                    map[10 + i]?.apply {
//                        if (contains(c)) {
//                            return false
//                        }
//                        add(c)
//                    }
//
//                    val p = 100 + index / 3 * 10 + i / 3
//                    map[p] = map.getOrDefault(p, arrayListOf())
//                    map[p]?.apply {
//                        if (contains(c)) {
//                            return false
//                        }
//                        add(c)
//                    }
//                }
//            }
//        }
//        return true
//    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (i in 0..8) {
            // hori, veti, sqre分别表示行、列、小宫
            var hori = 0
            var veti = 0
            var sqre = 0
            for (j in 0..8) {
                // 由于传入为char，需要转换为int，减48
                val h = board[i][j].toInt() - 48
                val v = board[j][i].toInt() - 48
                val s = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3].toInt() - 48
                // "."的ASCII码为46，故小于0代表着当前符号位"."，不用讨论
                if (h > 0) {
                    hori = sodokuer(h, hori)
                }
                if (v > 0) {
                    veti = sodokuer(v, veti)
                }
                if (s > 0) {
                    sqre = sodokuer(s, sqre)
                }
                if (hori == -1 || veti == -1 || sqre == -1) {
                    return false
                }
            }
        }
        return true
    }

    private fun sodokuer(n: Int, `val`: Int): Int {
        return if (`val` shr n and 1 == 1) -1 else `val` xor (1 shl n)
    }
}