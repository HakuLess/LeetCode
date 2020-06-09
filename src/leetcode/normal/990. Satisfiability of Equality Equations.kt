package leetcode.normal

import leetcode.contest.utils.TypedUFS
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution990()
    s.equationsPossible(arrayOf("w==s", "p==q", "r==i", "v==s", "i==o", "k==g", "c==f", "n==v", "a==w", "d==w", "v==s", "l==m")).print()
}

class Solution990 {
    fun equationsPossible(equations: Array<String>): Boolean {
        val ufs = TypedUFS<Char>(26)
        equations.forEach {
            if (it[1] == '=') {
                ufs.union(it[0], it[3])
            }
        }
        equations.forEach {
            if (it[1] == '!') {
                if (ufs.typedFind(it[0]) == ufs.typedFind(it[3])) {
                    return false
                }
            }
        }
        return true
    }
}