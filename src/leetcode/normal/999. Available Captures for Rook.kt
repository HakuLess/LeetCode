package leetcode.normal

fun main(args: Array<String>) {

}

fun numRookCaptures(board: Array<CharArray>): Int {
    var startX = 0
    var startY = 0
    for (i in 0..7) {
        for (j in 0..7) {
            if (board[i][j] == 'R') {
                startX = j
                startY = i
            }
        }
    }

    var ans = 0
    if (startX > 0) {
        for (i in startX downTo 0) {
            if (board[startY][i] == 'B') {
                break
            } else if (board[startY][i] == 'p') {
                ans++
                break
            } else {
                continue
            }
        }
    }

    if (startX < 7) {
        for (i in startX..7) {
            if (board[startY][i] == 'B') {
                break
            } else if (board[startY][i] == 'p') {
                ans++
                break
            } else {
                continue
            }
        }
    }

    if (startY > 0) {
        for (i in startY downTo 0) {
            if (board[i][startX] == 'B') {
                break
            } else if (board[i][startX] == 'p') {
                ans++
                break
            } else {
                continue
            }
        }
    }

    if (startY < 7) {
        for (i in startY..7) {
            if (board[i][startX] == 'B') {
                break
            } else if (board[i][startX] == 'p') {
                ans++
                break
            } else {
                continue
            }
        }
    }
    return ans
}