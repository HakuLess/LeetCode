package leetcode.normal

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val hashSet = hashSetOf<Char>()

    for (i in 0..8) {
        hashSet.clear()
        for (j in 0..8) {
            if (board[i][j] != '.') {
                if (hashSet.contains(board[i][j])) {
                    return false
                } else {
                    hashSet.add(board[i][j])
                }
            }
        }
    }

    for (j in 0..8) {
        hashSet.clear()
        for (i in 0..8) {
            if (board[i][j] != '.') {
                if (hashSet.contains(board[i][j])) {
                    return false
                } else {
                    hashSet.add(board[i][j])
                }
            }
        }
    }

    val core = arrayListOf(Pair(1, 1), Pair(1, 4), Pair(1, 7),
            Pair(4, 1), Pair(4, 4), Pair(4, 7),
            Pair(7, 1), Pair(7, 4), Pair(7, 7))
    val dirs = arrayListOf(Pair(-1, -1), Pair(-1, 0), Pair(-1, 1),
            Pair(0, -1), Pair(0, 0), Pair(0, 1),
            Pair(1, -1), Pair(1, 0), Pair(1, 1))

    for (item in core) {
        hashSet.clear()
        for (dir in dirs) {
            if (board[item.first + dir.first][item.second + dir.second] != '.') {
                if (hashSet.contains(board[item.first + dir.first][item.second + dir.second])) {
                    return false
                } else {
                    hashSet.add(board[item.first + dir.first][item.second + dir.second])
                }
            }
        }
    }

    return true
}