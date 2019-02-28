package leetcode

class Solution212 {

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val ans = arrayListOf<String>()
        words.forEach {
            if (exist(board, it)) {
                ans.add(it)
            }
        }
        return ans.distinct()
    }

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val r = board.size
        val c = board[0].size
        val visited = Array(r) { BooleanArray(c) }

        for (i in 0 until r) {
            for (j in 0 until c) {
                if (explore(board, visited, word, i, j, 0)) {
                    return true
                }
            }
        }
        return false
    }

    private fun explore(board: Array<CharArray>, visited: Array<BooleanArray>, word: String, i: Int, j: Int, start: Int): Boolean {
        if (start >= word.length) {
            return true
        }
        if (i < 0 || i >= board.size ||
                j < 0 || j >= board[0].size ||
                visited[i][j] || board[i][j] != word[start]) {
            return false
        }

        visited[i][j] = true
        val result = explore(board, visited, word, i - 1, j, start + 1) ||
                explore(board, visited, word, i + 1, j, start + 1) ||
                explore(board, visited, word, i, j - 1, start + 1) ||
                explore(board, visited, word, i, j + 1, start + 1)
        visited[i][j] = false
        return result
    }
}