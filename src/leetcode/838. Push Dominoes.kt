package leetcode

class Solution838 {
    fun pushDominoes(dominoes: String): String {
        var lastL = 0
        var lastR = -1
        val ans = CharArray(dominoes.length) { '.' }

        for (i in 0 until dominoes.length) {
            when (dominoes[i]) {
                'L' -> {
                    if (lastL > lastR) {
                        for (j in i downTo lastL) {
                            ans[j] = 'L'
                        }
                    } else {
                        var a = lastR
                        var b = i
                        while (a <= b) {
                            if (a != b) {
                                ans[a] = 'R'
                                ans[b] = 'L'
                            } else {
                                ans[a] = '.'
                            }

                            a++
                            b--
                        }
                    }
                    lastL = i
                }
                'R' -> {
                    lastR = i
                    ans[i] = 'R'
                }
                '.' -> {
                    if (lastR >= lastL) {
                        ans[i] = 'R'
                    }
                }
            }
        }

        return String(ans)
    }
}